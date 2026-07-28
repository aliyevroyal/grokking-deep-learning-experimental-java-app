package com.thealiyev;

import com.thealiyev.chapter3.ASimpleNeuralNetworkWithMultipleInputsAndMultipleOutputs;
import com.thealiyev.chapter3.ASimpleNeuralNetworkWithMultipleInputsAndSingleOutput;
import com.thealiyev.chapter3.ASimpleNeuralNetworkWithSingleInputAndMultipleOutputs;
import com.thealiyev.chapter3.ASimpleNeuralNetworkWithSingleInputAndSingleOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        LOGGER.info("A Simple Neural Network with Single Input and Starts!");
        ASimpleNeuralNetworkWithSingleInputAndSingleOutput aSimpleNeuralNetworkWithSingleInputAndSingleOutput = new ASimpleNeuralNetworkWithSingleInputAndSingleOutput();
        aSimpleNeuralNetworkWithSingleInputAndSingleOutput.predict();
        LOGGER.info("Prediction:" + aSimpleNeuralNetworkWithSingleInputAndSingleOutput.getPrediction());

        LOGGER.info("A Simple Neural Network with Multiple Input Starts!");
        ASimpleNeuralNetworkWithMultipleInputsAndSingleOutput aSimpleNeuralNetworkWithMultipleInputsAndSingleOutput = new ASimpleNeuralNetworkWithMultipleInputsAndSingleOutput();
        aSimpleNeuralNetworkWithMultipleInputsAndSingleOutput.predict();
        LOGGER.info("Prediction: " + aSimpleNeuralNetworkWithMultipleInputsAndSingleOutput.getPrediction());


        LOGGER.info("A Simple Neural Network with a Single Input and Multiple Outputs Starts!");
        ASimpleNeuralNetworkWithSingleInputAndMultipleOutputs aSimpleNeuralNetworkWithSingleInputAndMultipleOutputs = new ASimpleNeuralNetworkWithSingleInputAndMultipleOutputs();
        aSimpleNeuralNetworkWithSingleInputAndMultipleOutputs.predict();
        LOGGER.info("Predictions: " + aSimpleNeuralNetworkWithSingleInputAndMultipleOutputs.getPredictions());


        LOGGER.info("A Simple Neural Network with a Multiple Inputs and Multiple Outputs Starts!");
        ASimpleNeuralNetworkWithMultipleInputsAndMultipleOutputs aSimpleNeuralNetworkWithMultipleInputsAndMultipleOutputs = new ASimpleNeuralNetworkWithMultipleInputsAndMultipleOutputs();
        aSimpleNeuralNetworkWithMultipleInputsAndMultipleOutputs.predict();
        LOGGER.info("Predictions: " + aSimpleNeuralNetworkWithMultipleInputsAndMultipleOutputs.getPredictionsMatrix());
    }
}
