package com.thealiyev.chapter3.multilayerann;

import java.util.ArrayList;

public class AThreeLayersNeuralNetworkWithMultipleInputsAndMultipleOutputs {
    private ArrayList<Double> theNumberOfToesPerPlayer;
    private ArrayList<Double> wonPercent;
    private ArrayList<Double> theNumberOfFansInMillion;
    private ArrayList<Double> inputsVector;
    private ArrayList<ArrayList<Double>> inputsMatrix;
    private ArrayList<Double> weightsVectorForInputLayer;
    private ArrayList<ArrayList<Double>> weightsMatrixForInputLayer;
    private ArrayList<Double> weightsVectorForHiddenLayer;
    private ArrayList<ArrayList<Double>> weightsMatrixForHiddenLayer;
    private ArrayList<ArrayList<Double>> predictionsMatrix;

    public AThreeLayersNeuralNetworkWithMultipleInputsAndMultipleOutputs() {
        theNumberOfToesPerPlayer = new ArrayList<>();
        theNumberOfToesPerPlayer.add(8.5);
        theNumberOfToesPerPlayer.add(9.5);
        theNumberOfToesPerPlayer.add(9.9);
        theNumberOfToesPerPlayer.add(9.0);

        wonPercent = new ArrayList<>();
        wonPercent.add(0.65);
        wonPercent.add(0.8);
        wonPercent.add(0.8);
        wonPercent.add(0.9);

        theNumberOfFansInMillion = new ArrayList<>();
        theNumberOfFansInMillion.add(1.2);
        theNumberOfFansInMillion.add(1.3);
        theNumberOfFansInMillion.add(0.5);
        theNumberOfFansInMillion.add(1.0);

        inputsMatrix = new ArrayList<>();
        for (int counter = 0; counter < theNumberOfToesPerPlayer.size(); counter = counter + 1) {
            inputsVector = new ArrayList<>();
            inputsVector.add(theNumberOfToesPerPlayer.get(counter));
            inputsVector.add(wonPercent.get(counter));
            inputsVector.add(theNumberOfFansInMillion.get(counter));
            inputsMatrix.add(inputsVector);
        }


        weightsMatrixForInputLayer = new ArrayList<>();
        weightsVectorForInputLayer = new ArrayList<>();
        weightsVectorForInputLayer.add(0.1);
        weightsVectorForInputLayer.add(0.2);
        weightsVectorForInputLayer.add(-0.1);
        weightsMatrixForInputLayer.add(weightsVectorForInputLayer);

        weightsVectorForInputLayer = new ArrayList<>();
        weightsVectorForInputLayer.add(-0.1);
        weightsVectorForInputLayer.add(0.1);
        weightsVectorForInputLayer.add(0.9);
        weightsMatrixForInputLayer.add(weightsVectorForInputLayer);

        weightsVectorForInputLayer = new ArrayList<>();
        weightsVectorForInputLayer.add(0.1);
        weightsVectorForInputLayer.add(0.4);
        weightsVectorForInputLayer.add(0.1);
        weightsMatrixForInputLayer.add(weightsVectorForInputLayer);


        weightsMatrixForHiddenLayer = new ArrayList<>();
        weightsVectorForHiddenLayer = new ArrayList<>();
        weightsVectorForHiddenLayer.add(0.3);
        weightsVectorForHiddenLayer.add(1.1);
        weightsVectorForHiddenLayer.add(-0.3);
        weightsMatrixForHiddenLayer.add(weightsVectorForHiddenLayer);

        weightsVectorForHiddenLayer = new ArrayList<>();
        weightsVectorForHiddenLayer.add(0.1);
        weightsVectorForHiddenLayer.add(0.2);
        weightsVectorForHiddenLayer.add(0.0);
        weightsMatrixForHiddenLayer.add(weightsVectorForHiddenLayer);

        weightsVectorForHiddenLayer = new ArrayList<>();
        weightsVectorForHiddenLayer.add(0.0);
        weightsVectorForHiddenLayer.add(1.3);
        weightsVectorForHiddenLayer.add(0.1);
        weightsMatrixForHiddenLayer.add(weightsVectorForHiddenLayer);


        predict(predict(inputsMatrix, weightsMatrixForInputLayer), weightsMatrixForHiddenLayer);
    }

    public ArrayList<ArrayList<Double>> predict(ArrayList<ArrayList<Double>> inputsMatrix, ArrayList<ArrayList<Double>> weightsMatrix) {
        double prediction;

        ArrayList<Double> predictionsVector;
        predictionsMatrix = new ArrayList<>();
        for (int firstCounter = 0; firstCounter < inputsMatrix.size(); firstCounter = firstCounter + 1) {
            predictionsVector = new ArrayList<>();
            for (int secondCounter = 0; secondCounter < weightsMatrix.size(); secondCounter = secondCounter + 1) {//!!!
                prediction = 0.0;
                for (int thirdCounter = 0; thirdCounter < weightsMatrix.get(secondCounter).size(); thirdCounter = thirdCounter + 1) {
                    prediction = prediction + inputsMatrix.get(firstCounter).get(thirdCounter) * weightsMatrix.get(secondCounter).get(thirdCounter);
                }
                predictionsVector.add(prediction);
            }
            predictionsMatrix.add(predictionsVector);
        }

        return predictionsMatrix;
    }

    public ArrayList<ArrayList<Double>> getPredictionsMatrix() {
        return predictionsMatrix;
    }
}
