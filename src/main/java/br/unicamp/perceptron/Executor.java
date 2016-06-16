package br.unicamp.perceptron;

public class Executor {

	private static final Double[][] AMOSTRAS = new Double[][] {
		{0d, 0d, 1d},
		{0d, 1d, 1d},
		{1d, 0d, 1d},
		{1d, 1d, 1d}
    };

	private static final Double[] ESPERADOS = new Double[] { 0d, 0d, 0d, 1.0d };

	public static void main(String[] args) {

		Neuronio rede = new Neuronio(AMOSTRAS, ESPERADOS);
		rede.treinar();

		// TODO trocar o padrao para testar.
		Double[] padrao = {1d, 0d, 1d};

		// teste.
		Double saida = rede.classificar(padrao);

		Executor.imprimirResultadosProcessamento(rede, saida);
	}

	private static void imprimirResultadosProcessamento(Neuronio rede, Double saida) {
		StringBuilder conhecimento = new StringBuilder();
		Double[] pesos = rede.getPesos();
		for (int i = 0; i < pesos.length; i++) {
			conhecimento.append("\t[");
			conhecimento.append(i);
			conhecimento.append("]: ");
			conhecimento.append(pesos[i]);
			if (i < (pesos.length - 1)) {
				conhecimento.append("\n");
			}
		}

		System.out.println(String.format("- O valor calculado pela rede foi %s, depois de %s epocas de treinamento.", saida.toString(), rede.getEpocas()));
		System.out.println(String.format("- Conhecimento obtido durante a fase de treinamento: \n%s", conhecimento.toString()));
	}

}