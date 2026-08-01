package com.thealiyev.chapter4.singlelayerann;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class ASingleLayerNeuralNetworkWithMultipleInputsAndSingleOutput {
    private static final Logger LOGGER = LoggerFactory.getLogger(ASingleLayerNeuralNetworkWithMultipleInputsAndSingleOutput.class);
    private static final double alpha = 0.3;

    private ArrayList<Double> theNumberOfToesPerPlayer;
    private ArrayList<Double> wonPercent;
    private ArrayList<Double> theNumberOfFansInMillion;
    private ArrayList<Double> inputs;
    private ArrayList<Double> weights;
    private double prediction;
    private ArrayList<Double> targets;
    private double target;
    double loss;
    double gradient;

    public ASingleLayerNeuralNetworkWithMultipleInputsAndSingleOutput() {
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

        inputs = new ArrayList<>();
        inputs.add(theNumberOfToesPerPlayer.get(0));
        inputs.add(wonPercent.get(0));
        inputs.add(theNumberOfFansInMillion.get(0));

        weights = new ArrayList<>();
        weights.add(0.1);
        weights.add(0.2);
        weights.add(-0.1);

        prediction = 0.0;

        targets = new ArrayList<>();
        targets.add(1.0);
        targets.add(1.0);
        targets.add(0.0);
        targets.add(1.0);
        target = targets.get(0);
    }

    public void neuralNetwork() {
        LOGGER.info("Given Weights: " + weights);

        for (int iteration = 0; iteration < 1; iteration = iteration + 1) {
            for (int counter = 0; counter < inputs.size(); counter = counter + 1) {
                prediction = prediction + inputs.get(counter) * weights.get(counter);
            }

            loss = Math.pow((prediction - target), 2);
            LOGGER.info("Loss: " + loss);

            for (int counter = 1; counter < weights.size(); counter = counter + 1) {
                gradient = (prediction - target) * inputs.get(counter);
                weights.set(counter, (weights.get(counter) - alpha * gradient));
            }
            LOGGER.info("Current Weights: " + weights);
        }

    }

    public double getPrediction() {
        return prediction;
    }
}
