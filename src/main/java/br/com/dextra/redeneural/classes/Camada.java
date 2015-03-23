package br.com.dextra.redeneural.classes;

public class Camada {

	protected Neuronio neuronios[];
	
	public Camada(Integer nrNeuronios, Integer nrConexoesEntrada) {
		this.neuronios = new Neuronio[nrNeuronios];
		this.inicializarNeuronios(nrConexoesEntrada);
	}

	protected void inicializarNeuronios(Integer nrConexoesEntrada) {
		for (int i = 0; i < neuronios.length; i++) {
			neuronios[i] = new Neuronio(nrConexoesEntrada);
		}
	}

	public Double[] propagarSinais(Double entradas[]) {
		Double saidas[] = new Double[neuronios.length];
		for (int i = 0; i < neuronios.length; i++) {
			saidas[i] = neuronios[i].propagarSinais(entradas);
		}
		return saidas;
	}
	
}