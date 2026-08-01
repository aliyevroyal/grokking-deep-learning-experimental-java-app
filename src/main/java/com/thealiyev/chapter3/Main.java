package com.thealiyev.chapter3;

import com.thealiyev.chapter3.multilayerann.AThreeLayersNeuralNetworkWithMultipleInputsAndMultipleOutputs;
import com.thealiyev.chapter3.singlelayerann.ASingleLayerNeuralNetworkWithMultipleInputsAndMultipleOutputs;
import com.thealiyev.chapter3.singlelayerann.ASingleLayerNeuralNetworkWithMultipleInputsAndSingleOutput;
import com.thealiyev.chapter3.singlelayerann.ASingleLayerNeuralNetworkWithSingleInputAndMultipleOutputs;
import com.thealiyev.chapter3.singlelayerann.ASingleLayerNeuralNetworkWithSingleInputAndSingleOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("A Single Layer Neural Network with Single Input and Starts!");
        ASingleLayerNeuralNetworkWithSingleInputAndSingleOutput aSingleLayerNeuralNetworkWithSingleInputAndSingleOutput = new ASingleLayerNeuralNetworkWithSingleInputAndSingleOutput();
        aSingleLayerNeuralNetworkWithSingleInputAndSingleOutput.predict();
        LOGGER.info("Prediction:" + aSingleLayerNeuralNetworkWithSingleInputAndSingleOutput.getPrediction());

        LOGGER.info("A Single Layer Neural Network with Multiple Input Starts!");
        ASingleLayerNeuralNetworkWithMultipleInputsAndSingleOutput aSingleLayerNeuralNetworkWithMultipleInputsAndSingleOutput = new ASingleLayerNeuralNetworkWithMultipleInputsAndSingleOutput();
        aSingleLayerNeuralNetworkWithMultipleInputsAndSingleOutput.predict();
        LOGGER.info("Prediction: " + aSingleLayerNeuralNetworkWithMultipleInputsAndSingleOutput.getPrediction());


        LOGGER.info("A Single Layer Neural Network with a Single Input and Multiple Outputs Starts!");
        ASingleLayerNeuralNetworkWithSingleInputAndMultipleOutputs aSingleLayerNeuralNetworkWithSingleInputAndMultipleOutputs = new ASingleLayerNeuralNetworkWithSingleInputAndMultipleOutputs();
        aSingleLayerNeuralNetworkWithSingleInputAndMultipleOutputs.predict();
        LOGGER.info("Predictions: " + aSingleLayerNeuralNetworkWithSingleInputAndMultipleOutputs.getPredictions());


        LOGGER.info("A Single Layer Neural Network with a Multiple Inputs and Multiple Outputs Starts!");
        ASingleLayerNeuralNetworkWithMultipleInputsAndMultipleOutputs aSingleLayerNeuralNetworkWithMultipleInputsAndMultipleOutputs = new ASingleLayerNeuralNetworkWithMultipleInputsAndMultipleOutputs();
        aSingleLayerNeuralNetworkWithMultipleInputsAndMultipleOutputs.predict();
        LOGGER.info("Predictions: " + aSingleLayerNeuralNetworkWithMultipleInputsAndMultipleOutputs.getPredictionsMatrix());


        LOGGER.info("A Three Layers Neural Network with a Multiple Inputs and Multiple Outputs Starts!");
        AThreeLayersNeuralNetworkWithMultipleInputsAndMultipleOutputs aThreeLayersNeuralNetworkWithMultipleInputsAndMultipleOutputs = new AThreeLayersNeuralNetworkWithMultipleInputsAndMultipleOutputs();
        LOGGER.info("Predictions: " + aThreeLayersNeuralNetworkWithMultipleInputsAndMultipleOutputs.getPredictionsMatrix());
    }
}
