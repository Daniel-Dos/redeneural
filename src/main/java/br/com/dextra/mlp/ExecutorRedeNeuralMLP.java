package br.com.dextra.mlp;


public class ExecutorRedeNeuralMLP {

	private static double[][] CONJUNTO_TREINAMENTO = {
		{0.0, 0.0, 1.0, 1.0},
		{0.0, 1.0, 0.0, 1.0},
		{1.0, 1.0, 1.0, 1.0} // bias
	};

	private static double[] VALORES_ESPERADOS = {0.0, 1.0, 1.0, 0.0};

	public static void main(String[] args) {

		int nrNeuroniosPrimeiraCamada = 3;
		int nrNeuroniosEntrada = 3;

		RedeNeuralMLP rede = new RedeNeuralMLP(nrNeuroniosPrimeiraCamada, nrNeuroniosEntrada);

		System.out.println("Teste antes do treinamento: --------------------------------------------------------------------------- \n");
		ExecutorRedeNeuralMLP.imprimirTesteDeClassificacao(rede);

		rede.treinar(ExecutorRedeNeuralMLP.CONJUNTO_TREINAMENTO, ExecutorRedeNeuralMLP.VALORES_ESPERADOS);

		System.out.println("\n Teste depois do treinamento: ----------------------------------------------------------------------- \n");
		ExecutorRedeNeuralMLP.imprimirTesteDeClassificacao(rede);

	}

	private static void imprimirTesteDeClassificacao(RedeNeuralMLP rede) {
		rede.classificar(new double[] { 0.0, 0.0, 1.0 });
		rede.classificar(new double[] { 0.0, 1.0, 1.0 });
		rede.classificar(new double[] { 1.0, 0.0, 1.0 });
		rede.classificar(new double[] { 1.0, 1.0, 1.0 });
	}

}