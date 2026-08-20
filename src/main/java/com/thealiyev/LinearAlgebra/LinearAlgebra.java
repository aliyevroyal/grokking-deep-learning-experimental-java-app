package com.thealiyev.LinearAlgebra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class LinearAlgebra {
    private static final Logger LOGGER = LoggerFactory.getLogger(LinearAlgebra.class);

    //Vector Operations
    public List<Double> addVectors(List<Double> firstVector, List<Double> secondVector) {
        List<Double> resultVector = new ArrayList<>();

        for (int counter = 0; counter < firstVector.size(); counter = counter + 1) {
            resultVector.add(firstVector.get(counter) + secondVector.get(counter));
        }

        return resultVector;
    }

    public List<Double> subtractVectors(List<Double> firstVector, List<Double> secondVector) {
        List<Double> resultVector = new ArrayList<>();

        for (int counter = 0; counter < firstVector.size(); counter = counter + 1) {
            resultVector.add(firstVector.get(counter) - secondVector.get(counter));
        }

        return resultVector;
    }

    public List<Double> multiplyVectorByScalar(List<Double> vector, double scalar) {
        List<Double> resultVector = new ArrayList<>();

        for (int counter = 0; counter < vector.size(); counter = counter + 1) {
            resultVector.add(vector.get(counter) * scalar);
        }

        return resultVector;
    }

    public List<Double> divideVectorByScalar(List<Double> vector, double scalar) {
        if (Math.abs(scalar) < 1e-10) {
            LOGGER.error("Division by zero attempted!");
            throw new IllegalArgumentException("Cannot divide by zero!");
        }

        List<Double> resultVector = new ArrayList<>();

        for (int counter = 0; counter < vector.size(); counter = counter + 1) {
            resultVector.add(vector.get(counter) / scalar);
        }

        return resultVector;
    }

    public List<Double> multiplyVectorsElementWise(List<Double> firstVector, List<Double> secondVector) {
        List<Double> resultVector = new ArrayList<>();

        for (int counter = 0; counter < firstVector.size(); counter = counter + 1) {
            resultVector.add(firstVector.get(counter) * secondVector.get(counter));
        }

        return resultVector;
    }

    public List<Double> divideVectorsElementWise(List<Double> firstVector, List<Double> secondVector) {
        List<Double> resultVector = new ArrayList<>();

        for (int counter = 0; counter < firstVector.size(); counter = counter + 1) {
            if (Math.abs(secondVector.get(counter)) < 1e-10) {
                LOGGER.error("Division by zero attempted!");
                throw new IllegalArgumentException("Cannot divide by zero!");
            }

            resultVector.add(firstVector.get(counter) / secondVector.get(counter));
        }

        return resultVector;
    }

    public double calculateDotProduct(List<Double> firstVector, List<Double> secondVector) {
        double sum = 0.0;

        for (int counter = 0; counter < firstVector.size(); counter = counter + 1) {
            sum = sum + firstVector.get(counter) * secondVector.get(counter);
        }

        return sum;
    }

    public double calculateMagnitude(List<Double> vector) {
        double sum = 0.0;

        for (int counter = 0; counter < vector.size(); counter = counter + 1) {
            sum = sum + Math.pow(vector.get(counter), 2);
        }

        sum = Math.sqrt(sum);

        return sum;
    }

    public double calculateSumOfElementsOfVector(List<Double> vector) {
        double sum = 0.0;

        for (int counter = 0; counter < vector.size(); counter = counter + 1) {
            sum = sum + vector.get(counter);
        }

        return sum;
    }

    //Matrix Operations
    public List<List<Double>> addMatrices(List<List<Double>> firstMatrix, List<List<Double>> secondMatrix) {
        List<List<Double>> resultMatrix = new ArrayList<>();
        List<Double> resultVector;

        for (int row = 0; row < firstMatrix.size(); row = row + 1) {
            resultVector = new ArrayList<>();
            for (int column = 0; column < firstMatrix.get(row).size(); column = column + 1) {
                resultVector.add(firstMatrix.get(row).get(column) + secondMatrix.get(row).get(column));
            }
            resultMatrix.add(resultVector);
        }

        return resultMatrix;
    }

    public List<List<Double>> subtractMatrices(List<List<Double>> firstMatrix, List<List<Double>> secondMatrix) {
        List<List<Double>> resultMatrix = new ArrayList<>();
        List<Double> resultVector;

        for (int row = 0; row < firstMatrix.size(); row = row + 1) {
            resultVector = new ArrayList<>();
            for (int column = 0; column < firstMatrix.get(row).size(); column = column + 1) {
                resultVector.add(firstMatrix.get(row).get(column) - secondMatrix.get(row).get(column));
            }
            resultMatrix.add(resultVector);
        }

        return resultMatrix;
    }

    public List<List<Double>> multiplyMatrices(List<List<Double>> firstMatrix, List<List<Double>> secondMatrix) {
        List<List<Double>> resultMatrix = new ArrayList<>();
        List<Double> resultVector;
        double result;

        for (int rowOfFirstMatrix = 0; rowOfFirstMatrix < firstMatrix.size(); rowOfFirstMatrix = rowOfFirstMatrix + 1) {
            resultVector = new ArrayList<>();
            for (int columnOfSecondMatrix = 0; columnOfSecondMatrix < secondMatrix.get(0).size(); columnOfSecondMatrix = columnOfSecondMatrix + 1) {
                result = 0.0;
                for (int rowOfSecondMatrix = 0; rowOfSecondMatrix < secondMatrix.size(); rowOfSecondMatrix = rowOfSecondMatrix + 1) {//or the number of columns of firstMatrix could be used...
                    result = result + firstMatrix.get(rowOfFirstMatrix).get(rowOfSecondMatrix) * secondMatrix.get(rowOfSecondMatrix).get(columnOfSecondMatrix);
                }
                resultVector.add(result);
            }
            resultMatrix.add(resultVector);
        }

        return resultMatrix;
    }

    public List<List<Double>> multiplyMatrixByScalar(List<List<Double>> matrix, double scalar) {
        List<List<Double>> resultMatrix = new ArrayList<>();
        List<Double> resultVector;

        for (int row = 0; row < matrix.size(); row = row + 1) {
            resultVector = new ArrayList<>();
            for (int column = 0; column < matrix.get(row).size(); column = column + 1) {
                resultVector.add(matrix.get(row).get(column) * scalar);
            }
            resultMatrix.add(resultVector);
        }

        return resultMatrix;
    }

    public List<List<Double>> divideMatrixByScalar(List<List<Double>> matrix, double scalar) {
        if (Math.abs(scalar) < 1e-10) {
            LOGGER.error("Division by zero attempted!");
            throw new IllegalArgumentException("Cannot divide by zero!");
        }

        List<List<Double>> resultMatrix = new ArrayList<>();
        List<Double> resultVector;

        for (int row = 0; row < matrix.size(); row = row + 1) {
            resultVector = new ArrayList<>();
            for (int column = 0; column < matrix.get(row).size(); column = column + 1) {
                resultVector.add(matrix.get(row).get(column) / scalar);
            }
            resultMatrix.add(resultVector);
        }

        return resultMatrix;
    }


    public List<List<Double>> multiplyMatricesElementWise(List<List<Double>> firstMatrix, List<List<Double>> secondMatrix) {
        List<List<Double>> resultMatrix = new ArrayList<>();
        List<Double> resultVector;

        for (int row = 0; row < firstMatrix.size(); row = row + 1) {
            resultVector = new ArrayList<>();
            for (int column = 0; column < firstMatrix.get(row).size(); column = column + 1) {
                resultVector.add(firstMatrix.get(row).get(column) * secondMatrix.get(row).get(column));
            }
            resultMatrix.add(resultVector);
        }

        return resultMatrix;
    }

    public List<List<Double>> divideMatricesElementWise(List<List<Double>> firstMatrix, List<List<Double>> secondMatrix) {
        List<List<Double>> resultMatrix = new ArrayList<>();
        List<Double> resultVector;

        for (int row = 0; row < firstMatrix.size(); row = row + 1) {
            resultVector = new ArrayList<>();
            for (int column = 0; column < firstMatrix.get(row).size(); column = column + 1) {
                if (Math.abs(secondMatrix.get(row).get(column)) < 1e-10) {
                    LOGGER.error("Division by zero attempted!");
                    throw new IllegalArgumentException("Cannot divide by zero!");
                }

                resultVector.add(firstMatrix.get(row).get(column) / secondMatrix.get(row).get(column));
            }
            resultMatrix.add(resultVector);
        }

        return resultMatrix;
    }

    public List<List<Double>> transposeMatrix(List<List<Double>> matrix) {
        List<List<Double>> resultMatrix = new ArrayList<>();
        List<Double> resultVector;

        for (int column = 0; column < matrix.get(0).size(); column = column + 1) {
            resultVector = new ArrayList<>();
            for (int row = 0; row < matrix.size(); row = row + 1) {
                resultVector.add(matrix.get(row).get(column));
            }
            resultMatrix.add(resultVector);
        }

        return resultMatrix;
    }
}
