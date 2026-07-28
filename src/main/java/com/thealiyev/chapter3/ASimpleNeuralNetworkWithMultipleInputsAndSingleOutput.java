package com.thealiyev.chapter3;

import java.util.ArrayList;

public class ASimpleNeuralNetworkWithMultipleInputsAndSingleOutput {
    private ArrayList<Double> theNumberOfToesPerPlayer;
    private ArrayList<Double> wonPercent;
    private ArrayList<Double> theNumberOfFansInMillion;
    private ArrayList<Double> inputs;
    private ArrayList<Double> weights;
    private double prediction;

    public ASimpleNeuralNetworkWithMultipleInputsAndSingleOutput() {
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
        weights.add(0.0);

        prediction = 0.0;
    }

    public void predict() {
        for (int counter = 0; counter < inputs.size(); counter = counter + 1) {
            prediction = prediction + inputs.get(counter) * weights.get(counter);
        }
    }

    public double getPrediction() {
        return prediction;
    }
}
