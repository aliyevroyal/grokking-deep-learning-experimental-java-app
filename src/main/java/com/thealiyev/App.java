package com.thealiyev;

import com.thealiyev.chapter3.ASimpleNeuralNetworkWithMultipleInputs;
import com.thealiyev.chapter3.ASimpleNeuralNetworkWithSingleInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        LOGGER.info("A Simple Neural Network with Single Input Starts!");
        ASimpleNeuralNetworkWithSingleInput aSimpleNeuralNetworkWithSingleInput = new ASimpleNeuralNetworkWithSingleInput();
        aSimpleNeuralNetworkWithSingleInput.neuralNetwork();
        LOGGER.info("Prediction:" + aSimpleNeuralNetworkWithSingleInput.getPrediction());

        LOGGER.info("A Simple Neural Network with Multiple Input Starts!");
        ASimpleNeuralNetworkWithMultipleInputs aSimpleNeuralNetworkWithMultipleInputs = new ASimpleNeuralNetworkWithMultipleInputs();
        aSimpleNeuralNetworkWithMultipleInputs.neuralNetwork();
        LOGGER.info("Prediction: " + aSimpleNeuralNetworkWithMultipleInputs.getPrediction());
    }
}
