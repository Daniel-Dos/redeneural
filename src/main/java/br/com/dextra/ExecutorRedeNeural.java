package br.com.dextra;

public class ExecutorRedeNeural {

	private static double[][] CONJUNTO_TREINAMENTO = {
		{0.0, 0.0, 1.0, 1.0},
		{0.0, 1.0, 0.0, 1.0},
		{1.0, 1.0, 1.0, 1.0}
	};

	private static double[] VALORES_ESPERADOS = {0.0, 1.0, 1.0, 0.0};

	public static void main(String[] args) {

		int nrNeuroniosPrimeiraCamada = 2;
		int nrNeuroniosEntrada = 3;

		RedeNeural rede = new RedeNeural(nrNeuroniosPrimeiraCamada, nrNeuroniosEntrada);
		rede.treinar(ExecutorRedeNeural.CONJUNTO_TREINAMENTO, ExecutorRedeNeural.VALORES_ESPERADOS);

		rede.classificar(new double[] { 1.0, 0.0, 1.0 });

	}

}