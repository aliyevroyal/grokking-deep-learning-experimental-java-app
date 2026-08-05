package com.thealiyev.chapter4and5.singlelayerann;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ASingleLayerNeuralNetworkWithMultipleInputsAndMultipleOutputs {
    private static final Logger LOGGER = LoggerFactory.getLogger(ASingleLayerNeuralNetworkWithMultipleInputsAndMultipleOutputs.class);
    private static final double alpha = 0.01;

    private List<Double> theNumberOfToesPerPlayer;
    private List<Double> wonPercent;
    private List<Double> theNumberOfFansInMillion;
    private List<Double> inputsVector;
    private List<List<Double>> inputsMatrix;
    private List<Double> weightsVector;
    private List<List<Double>> weightsMatrix;
    private List<Double> predictionsVector;
    private List<List<Double>> predictionsMatrix;
    private List<Double> hurtTargets;
    private List<Double> winTargets;
    private List<Double> sadTargets;
    private List<Double> targetsVector;
    private List<List<Double>> targetsMatrix;
    double loss;
    double gradient;

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
        LOGGER.info("Inputs Matrix: " + inputsMatrix);

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

        hurtTargets = new ArrayList<>();
        hurtTargets.add(0.1);
        hurtTargets.add(0.0);
        hurtTargets.add(0.0);
        hurtTargets.add(0.1);

        winTargets = new ArrayList<>();
        winTargets.add(1.0);
        winTargets.add(1.0);
        winTargets.add(0.0);
        winTargets.add(1.0);

        sadTargets = new ArrayList<>();
        sadTargets.add(0.1);
        sadTargets.add(0.0);
        sadTargets.add(0.1);
        sadTargets.add(0.2);

        targetsMatrix = new ArrayList<>();
        for (int counter = 0; counter < hurtTargets.size(); counter = counter + 1) {
            targetsVector = new ArrayList<>();
            targetsVector.add(hurtTargets.get(counter));
            targetsVector.add(winTargets.get(counter));
            targetsVector.add(sadTargets.get(counter));
            targetsMatrix.add(targetsVector);
        }

        LOGGER.info("Targets Matrix: " + targetsMatrix);
    }

    public void neuralNetwork() {
        LOGGER.info("Given Weights: " + weightsMatrix);

        double prediction;
        predictionsMatrix = new ArrayList<>();
        for (int iteration = 0; iteration < 1; iteration = iteration + 1) {
            predictionsVector = new ArrayList<>();
            for (int firstCounter = 0; firstCounter < weightsMatrix.size(); firstCounter = firstCounter + 1) {
                prediction = 0.0;
                for (int secondCounter = 0; secondCounter < weightsMatrix.get(firstCounter).size(); secondCounter = secondCounter + 1) {
                    prediction = prediction + inputsMatrix.get(0).get(secondCounter) * weightsMatrix.get(firstCounter).get(secondCounter);
                }

                loss = Math.pow((prediction - targetsMatrix.get(0).get(firstCounter)), 2);
                LOGGER.info("Target: " + targetsMatrix.get(0).get(firstCounter) + ", Loss: " + loss);

                for (int secondCounter = 0; secondCounter < weightsMatrix.get(firstCounter).size(); secondCounter = secondCounter + 1) {
                    gradient = (prediction - targetsMatrix.get(0).get(firstCounter)) * inputsMatrix.get(0).get(secondCounter);
                    weightsMatrix.get(firstCounter).set(secondCounter, (weightsMatrix.get(firstCounter).get(secondCounter) - alpha * gradient));
                }

                predictionsVector.add(prediction);
            }
            predictionsMatrix.add(predictionsVector);
            LOGGER.info("Current Weights: " + weightsMatrix);
        }
    }

    public List<List<Double>> getPredictionsMatrix() {
        return predictionsMatrix;
    }
}
