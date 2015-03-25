package br.com.dextra.weka;

import java.io.FileReader;

import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instance;
import weka.core.Instances;

public class NeuralNetwork {

	public static void main(String[] args) throws Exception {

		FileReader reader = new FileReader("/home/everton.gago/projetos/redeneural/iris.arff");
		Instances trainningInstances = new Instances(reader);
		trainningInstances.setClassIndex(4);

		MultilayerPerceptron mlp = new MultilayerPerceptron();
		mlp.buildClassifier(trainningInstances);

		int corretas = 0;
		int numInstances = trainningInstances.numInstances();

		for (int i = 0; i < numInstances; i++) {
			Instance instance = trainningInstances.instance(i);
			double classe = mlp.classifyInstance(instance);
			if (classe == instance.classValue()) {
				corretas++;
			}
		}

		System.out.printf("De %d instancias %d foram classificadas corretamente.", numInstances, corretas);


	}

}