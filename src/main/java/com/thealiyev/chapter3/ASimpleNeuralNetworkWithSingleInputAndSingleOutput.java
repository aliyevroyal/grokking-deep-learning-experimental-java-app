package com.thealiyev.chapter3;

import java.util.ArrayList;

public class ASimpleNeuralNetworkWithSingleInputAndSingleOutput {
    private ArrayList<Double> toes;
    private double input;
    private double weight;
    private double prediction;

    public ASimpleNeuralNetworkWithSingleInputAndSingleOutput() {
        toes = new ArrayList<>();
        toes.add(8.5);
        toes.add(9.5);
        toes.add(10.0);
        toes.add(9.0);
        input = toes.get(0);

        weight = 0.1;
    }

    public void predict() {
        prediction = input * weight;
    }

    public double getPrediction() {
        return prediction;
    }
}
