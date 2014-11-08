package br.com.dextra.slp;

import java.util.Random;

public class RedeNeuralSLP {

	private static final Double TAXA_APRENDIZADO = .05d;

	private Double[] esperados;
	private Double[][] amostras;
	private Double[] pesos;
	private int epocas;

	public RedeNeuralSLP(Double[][] amostras, Double[] esperados) {
		this.esperados = esperados;
		this.amostras = amostras;
		this.epocas = 0;
		this.atribuirValoresAleatoriosParaPesos();
	}

	public void treinar() {
		Boolean erro;
		do {
			erro = Boolean.FALSE;
			for (int i = 0; i < amostras.length; i++) {
				Double u = this.integrarSinal(i);
				Double saida = this.calcularSinalSaida(u);
				if (!saida.equals(esperados[i])) {
					this.aprender(saida, i);
					erro = Boolean.TRUE;
				}
			}
			epocas++;
		} while (erro);
	}

	public Double classificar(Double[] padrao) {
		Double u = 0d;
		for (int i = 0; i < pesos.length; i++) {
			u += pesos[i] * padrao[i];
		}
		return this.calcularSinalSaida(u);
	}

	private Double integrarSinal(int i) {
		Double u = 0d;
		for (int j = 0; j < pesos.length; j++) {
			u += pesos[j] * amostras[j][i];
		}
		return u;
	}

	private void aprender(Double saida, int i) {
		Double fatorAprendizado = RedeNeuralSLP.TAXA_APRENDIZADO + (esperados[i] - saida);
		for (int j = 0; j < pesos.length; j++) {
			pesos[j] += fatorAprendizado * amostras[j][i];
		}
	}

	private void atribuirValoresAleatoriosParaPesos() {
		Random random = new Random(System.currentTimeMillis());
		pesos = new Double[esperados.length];
		for (int i = 0; i < pesos.length; i++) {
			pesos[i] = 1.0 / (random.nextInt(100) + 1.0);
		}
	}

	private Double calcularSinalSaida(Double u) {
		return (u >= 0d) ? 1d : -1d;
	}

	public int getEpocas() {
		return epocas;
	}

	public Double[] getPesos() {
		return pesos;
	}

}