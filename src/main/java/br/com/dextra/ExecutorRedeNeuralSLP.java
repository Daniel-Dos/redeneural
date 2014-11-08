package br.com.dextra;

public class ExecutorRedeNeuralSLP {

	private static final Double[][] AMOSTRAS = new Double[][] {
        {-1.0d, -1.0d, -1.0d, -1.0d }, // bias
        { 0.1d,  0.3d,  0.6d,  0.5d }, // 
        { 0.4d,  0.7d,  0.9d,  0.7d }, // 
        { 0.7d,  0.2d,  0.8d,  0.1d }  // 
    };

	private static final Double[] ESPERADOS = new Double[] { 1.0d, -1.0d, -1.0d, 1.0d };

	public static void main(String[] args) {

		RedeNeuralSLP rede = new RedeNeuralSLP(AMOSTRAS, ESPERADOS);
		rede.treinar();

		Double[] padrao = {-1.0d, 0.5d, 0.7d, 0.1d};
		Double saida = rede.classificar(padrao);

		System.out.printf("Saída: %d; Nr de épocas: %d", saida.intValue(), rede.getEpocas());

	}

}