package com.thealiyev.chapter6.streetlight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class StreetLightExample {
    private static final Logger LOGGER = LoggerFactory.getLogger(StreetLightExample.class);
    private static final int ITERATIONS = 20;
    private static final double ALPHA = 0.1;

    private List<Double> input;
    private List<List<Double>> inputs;
    private List<Double> weight;
    private List<List<Double>> weights;
    private List<Double> output;
    private List<List<Double>> outputs;
    private List<Double> target;
    private List<List<Double>> targets;
    private double loss;
    private double gradient;
    private double theta;

    public StreetLightExample() {
        inputs = new ArrayList<>();
        input = new ArrayList<>();
        input.add(1.0);
        input.add(0.0);
        input.add(1.0);
        inputs.add(input);

        input = new ArrayList<>();
        input.add(0.0);
        input.add(1.0);
        input.add(1.0);
        inputs.add(input);

        input = new ArrayList<>();
        input.add(0.0);
        input.add(0.0);
        input.add(1.0);
        inputs.add(input);

        input = new ArrayList<>();
        input.add(1.0);
        input.add(1.0);
        input.add(1.0);
        inputs.add(input);

        input = new ArrayList<>();
        input.add(0.0);
        input.add(1.0);
        input.add(1.0);
        inputs.add(input);

        input = new ArrayList<>();
        input.add(1.0);
        input.add(0.0);
        input.add(1.0);
        inputs.add(input);


        weights = new ArrayList<>();
        weight = new ArrayList<>();
        weight.add(0.5);
        weight.add(0.48);
        weight.add(-0.7);
        weights.add(weight);


        targets = new ArrayList<>();
        target = new ArrayList<>();
        target.add(0.0);
        targets.add(target);
        target = new ArrayList<>();
        target.add(1.0);
        targets.add(target);
        target = new ArrayList<>();
        target.add(0.0);
        targets.add(target);
        target = new ArrayList<>();
        target.add(1.0);
        targets.add(target);
        target = new ArrayList<>();
        target.add(1.0);
        targets.add(target);
        target = new ArrayList<>();
        target.add(0.0);
        targets.add(target);

        LOGGER.info("Targets Matrix: " + targets);
    }

    public void neuralNetwork() {
        LOGGER.info("Given Weights: " + weights);

        double prediction;
        outputs = new ArrayList<>();
        for (int epoch = 0; epoch < ITERATIONS; epoch = epoch + 1) {
            output = new ArrayList<>();
            for (int sample = 0; sample < inputs.size(); sample = sample + 1) {
                for (int neuron = 0; neuron < weights.size(); neuron = neuron + 1) {
                    prediction = 0.0;
                    for (int feature = 0; feature < weights.get(neuron).size(); feature = feature + 1) {
                        prediction = prediction + inputs.get(sample).get(feature) * weights.get(neuron).get(feature);
                    }
                    loss = Math.pow((prediction - targets.get(sample).get(neuron)), 2);
                    LOGGER.info("Target: " + targets.get(sample).get(neuron) + ", Loss: " + loss);

                    for (int feature = 0; feature < weights.get(neuron).size(); feature = feature + 1) {
                        gradient = (prediction - targets.get(sample).get(neuron)) * inputs.get(sample).get(feature);
                        theta = weights.get(neuron).get(feature) - gradient * ALPHA;
                        weights.get(neuron).set(feature, theta);
                    }
                    output.add(prediction);
                    LOGGER.info("Current Weights: " + weights);
                }
            }
            outputs.add(output);
        }
    }

    public List<List<Double>> getOutputs() {
        return outputs;
    }
}
