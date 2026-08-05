package com.thealiyev.chapter3.singlelayerann;

import java.util.ArrayList;

public class ASingleLayerNeuralNetworkWithMultipleInputsAndMultipleOutputs {

    private ArrayList<Double> theNumberOfToesPerPlayer;
    private ArrayList<Double> wonPercent;
    private ArrayList<Double> theNumberOfFansInMillion;
    private ArrayList<Double> inputsVector;
    private ArrayList<ArrayList<Double>> inputsMatrix;
    private ArrayList<Double> weightsVector;
    private ArrayList<ArrayList<Double>> weightsMatrix;
    private ArrayList<Double> predictionsVector;
    private ArrayList<ArrayList<Double>> predictionsMatrix;

    public ASingleLayerNeuralNetworkWithMultipleInputsAndMultipleOutputs() {
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

        weightsMatrix = new ArrayList<>();
        weightsVector = new ArrayList<>();
        weightsVector.add(0.1);
        weightsVector.add(0.1);
        weightsVector.add(-0.3);
        weightsMatrix.add(weightsVector);

        weightsVector = new ArrayList<>();
        weightsVector.add(0.1);
        weightsVector.add(0.2);
        weightsVector.add(0.0);
        weightsMatrix.add(weightsVector);

        weightsVector = new ArrayList<>();
        weightsVector.add(0.0);
        weightsVector.add(1.3);
        weightsVector.add(0.1);
        weightsMatrix.add(weightsVector);
    }

    public void predict() {
        double prediction;
        predictionsMatrix = new ArrayList<>();
        for (int firstCounter = 0; firstCounter < inputsMatrix.size(); firstCounter = firstCounter + 1) {
            predictionsVector = new ArrayList<>();
            for (int secondCounter = 0; secondCounter < inputsMatrix.get(firstCounter).size(); secondCounter = secondCounter + 1) {
                prediction = 0.0;
                for (int thirdCounter = 0; thirdCounter < weightsMatrix.get(secondCounter).size(); thirdCounter = thirdCounter + 1) {
                    prediction = prediction + inputsMatrix.get(firstCounter).get(thirdCounter) * weightsMatrix.get(secondCounter).get(thirdCounter);
                }
                predictionsVector.add(prediction);
            }
            predictionsMatrix.add(predictionsVector);
        }
    }

    public ArrayList<ArrayList<Double>> getPredictionsMatrix() {
        return predictionsMatrix;
    }
}
