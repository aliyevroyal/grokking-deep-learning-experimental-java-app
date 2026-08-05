package com.thealiyev.chapter6;

import com.thealiyev.chapter6.streetlight.StreetLightExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Main method of Main Class of Chapter 6!");

        StreetLightExample streetLightExample = new StreetLightExample();
        streetLightExample.neuralNetwork();
        LOGGER.info("Predictions: " + streetLightExample.getOutputs());
    }
}
