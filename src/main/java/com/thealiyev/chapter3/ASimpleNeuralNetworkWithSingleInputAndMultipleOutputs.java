package com.thealiyev.chapter3;

import java.util.ArrayList;

public class ASimpleNeuralNetworkWithSingleInputAndMultipleOutputs {
    private ArrayList<Double> wonPercent;
    private ArrayList<Double> inputs;
    private ArrayList<Double> weights;
    private ArrayList<Double> predictions;

    public ASimpleNeuralNetworkWithSingleInputAndMultipleOutputs() {
        wonPercent = new ArrayList<>();
        wonPercent.add(0.65);

        inputs = new ArrayList<>();
        inputs.add(wonPercent.get(0));

        weights = new ArrayList<>();
        weights.add(0.3);
        weights.add(0.2);
        weights.add(0.9);

        predictions = new ArrayList<>();
    }

    public void predict() {
        for (int counter = 0; counter < weights.size(); counter = counter + 1) {
            predictions.add(inputs.get(0) * weights.get(counter));
        }
    }

    public ArrayList<Double> getPredictions() {
        return predictions;
    }
}
