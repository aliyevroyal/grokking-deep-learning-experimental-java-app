package com.thealiyev.chapter4.singlelayerann;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ASingleLayerNeuralNetworkWithSingleInputAndMultipleOutputs {
    private static final Logger LOGGER = LoggerFactory.getLogger(ASingleLayerNeuralNetworkWithSingleInputAndMultipleOutputs.class);
    private static final double alpha = 0.1;

    private List<Double> wonPercentage;
    private List<Double> inputs;
    private List<Double> weights;
    private List<Double> predictions;
    private double prediction;
    private List<Double> hurtTargets;
    private List<Double> winTargets;
    private List<Double> sadTargets;
    private List<Double> targets;
    double loss;
    double gradient;

    public ASingleLayerNeuralNetworkWithSingleInputAndMultipleOutputs() {
        wonPercentage = new ArrayList<>();
        wonPercentage.add(0.65);
        wonPercentage.add(1.0);
        wonPercentage.add(1.0);
        wonPercentage.add(0.9);

        inputs = new ArrayList<>();
        inputs.add(wonPercentage.get(0));

        weights = new ArrayList<>();
        weights.add(0.3);
        weights.add(0.2);
        weights.add(0.9);

        predictions = new ArrayList<>();

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

        targets = new ArrayList<>();
        targets.add(hurtTargets.get(0));
        targets.add(winTargets.get(0));
        targets.add(sadTargets.get(0));
    }

    public void neuralNetwork() {
        LOGGER.info("Given Weights: " + weights);

        for (int iteration = 0; iteration < 1; iteration = iteration + 1) {
            for (int counter = 0; counter < weights.size(); counter = counter + 1) {
                prediction = inputs.get(0) * weights.get(counter);
                predictions.add(prediction);

                loss = Math.pow((prediction - targets.get(counter)), 2);
                LOGGER.info("Loss: " + loss);

                gradient = (prediction - targets.get(counter)) * inputs.get(0);
                weights.set(counter, (weights.get(counter) - alpha * gradient));
            }

            LOGGER.info("Current Weights: " + weights);
        }
    }

    public List<Double> getPredictions() {
        return predictions;
    }
}
