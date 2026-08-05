package com.thealiyev.chapter4and5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GradientDescent {
    private static final Logger LOGGER = LoggerFactory.getLogger(GradientDescent.class);

    public GradientDescent() {
        double input = 2.0;
        double weight = 0.5;
        double prediction;
        double target = 0.8;
        double loss;
        double gradient;
        double alpha = 0.1;

        for (int iteration = 0; iteration < 20; iteration = iteration + 1) {
            prediction = input * weight;
            loss = Math.pow((prediction - target), 2);
            gradient = (prediction - target) * input;
            weight = weight - alpha * gradient;

            LOGGER.info("loss: " + loss + " prediction: " + prediction);
        }
    }
}
