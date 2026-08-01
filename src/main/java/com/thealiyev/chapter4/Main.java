package com.thealiyev.chapter4;

import com.thealiyev.chapter4.singlelayerann.ASingleLayerNeuralNetworkWithMultipleInputsAndMultipleOutputs;
import com.thealiyev.chapter4.singlelayerann.ASingleLayerNeuralNetworkWithMultipleInputsAndSingleOutput;
import com.thealiyev.chapter4.singlelayerann.ASingleLayerNeuralNetworkWithSingleInputAndMultipleOutputs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Learning learning = new Learning();

        GradientDescent gradientDescent = new GradientDescent();

        ASingleLayerNeuralNetworkWithMultipleInputsAndSingleOutput aSingleLayerNeuralNetworkWithMultipleInputsAndSingleOutput = new ASingleLayerNeuralNetworkWithMultipleInputsAndSingleOutput();
        aSingleLayerNeuralNetworkWithMultipleInputsAndSingleOutput.neuralNetwork();
        LOGGER.info("Prediction: " + aSingleLayerNeuralNetworkWithMultipleInputsAndSingleOutput.getPrediction());

        ASingleLayerNeuralNetworkWithSingleInputAndMultipleOutputs aSingleLayerNeuralNetworkWithSingleInputAndMultipleOutputs = new ASingleLayerNeuralNetworkWithSingleInputAndMultipleOutputs();
        aSingleLayerNeuralNetworkWithSingleInputAndMultipleOutputs.neuralNetwork();
        LOGGER.info("Predictions: " + aSingleLayerNeuralNetworkWithSingleInputAndMultipleOutputs.getPredictions());

        ASingleLayerNeuralNetworkWithMultipleInputsAndMultipleOutputs aSingleLayerNeuralNetworkWithMultipleInputsAndMultipleOutputs = new ASingleLayerNeuralNetworkWithMultipleInputsAndMultipleOutputs();
        aSingleLayerNeuralNetworkWithMultipleInputsAndMultipleOutputs.neuralNetwork();
        LOGGER.info("Predictions: " + aSingleLayerNeuralNetworkWithMultipleInputsAndMultipleOutputs.getPredictionsMatrix());
    }
}
