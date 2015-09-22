package br.com.dextra.mlp;

import java.io.FileNotFoundException;

public class ExecutorRedeNeuralMLP {
	
	private static final int DELTA_TEST = 80000;
	private static final int DELTA_TRAINING = (FileReader.LINE_NUMBER - DELTA_TEST);

	public static void main(String[] args) throws FileNotFoundException {
		FileReader fileReader = new FileReader("/home/dextra/projetos/unimed/data/data.csv");
		fileReader.read();
		double data[][] = fileReader.getData();
		long expect[] = fileReader.getExpect();
		
		// data training.
		double dataTraining[][] = new double[FileReader.LINE_ITEMS][DELTA_TRAINING];
		for (int i = 0; i < dataTraining.length; i++) {
			for (int j = 0; j < dataTraining[i].length; j++) {
				dataTraining[i][j] = data[i][j];
			}
		}
		
		// expect data training.
		long trainingExpect[] = new long[DELTA_TRAINING];
		for (int i = 0; i < trainingExpect.length; i++) {
			trainingExpect[i] = expect[i];
		}
		
		// data test.
		double dataTest[][] = new double[FileReader.LINE_ITEMS][DELTA_TEST];
		for (int i = 0; i < dataTest.length; i++) {
			for (int j = 0; j < dataTest[i].length; j++) {
				dataTest[i][j] = data[i][j + DELTA_TRAINING];
			}
		}
		
		// expect data test.
		long testExpect[] = new long[DELTA_TEST];
		for (int i = 0; i < testExpect.length; i++) {
			testExpect[i] = expect[i + DELTA_TRAINING];
		}
		
		int nrNeuroniosPrimeiraCamada = 10;
		int nrNeuroniosEntrada = 12;

		RedeNeuralMLP rede = new RedeNeuralMLP(nrNeuroniosPrimeiraCamada, nrNeuroniosEntrada);

		double doubleTrainingExpect[] = new double[trainingExpect.length];
		for (int i = 0; i < doubleTrainingExpect.length; i++) {
			doubleTrainingExpect[i] = new Double(trainingExpect[i]);
		}
		
		System.out.println("Treinar.");
		rede.treinar(dataTraining, doubleTrainingExpect);
		
		System.out.println("Processar saidas:");
		ExecutorRedeNeuralMLP.imprimirTesteDeClassificacao(rede, dataTest, testExpect);
	}

	private static void imprimirTesteDeClassificacao(RedeNeuralMLP rede, double data[][], long expect[]) {
		for (int i = 0; i < expect.length; i++) {
			double input[] = new double[FileReader.LINE_ITEMS];
			for (int j = 0; j < data.length; j++) {
				input[j] = data[j][i];
			}
			rede.classificar(input, expect[i]);
		}
		rede.imprimirEstatistica();
	}

}