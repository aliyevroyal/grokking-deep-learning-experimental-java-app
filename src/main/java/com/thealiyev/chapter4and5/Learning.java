package com.thealiyev.chapter4and5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Learning {
    private static final Logger LOGGER = LoggerFactory.getLogger(Learning.class);

    public Learning() {
        double input = 0.5;
        double weight = 0.5;
        double alpha = 0.001;
        double prediction;
        double target = 0.8;
        double error;

        double upPrediction;
        double upError;
        double downPrediction;
        double downError;

        for (int counter = 0; counter < 20; counter = counter + 1) {
            prediction = input * weight;
            error = Math.pow((prediction - target), 2);

            LOGGER.info("error: " + error + " prediction: " + prediction);

            upPrediction = input * (weight + alpha);
            upError = Math.pow((target - upPrediction), 2);

            downPrediction = input * (weight - alpha);
            downError = Math.pow((target - downPrediction), 2);

            if (downError < upError) {
                weight = weight - alpha;
            } else if (downError > upError) {
                weight = weight + alpha;
            }
        }
    }
}
