package br.com.dextra.redeneural.classes;

public class PerceptronMultiplasCamadas {
	
	private Camada camadaIntermediaria;
	private Camada camadaSaida;
	
	public PerceptronMultiplasCamadas(Integer nrEntradas, Integer nrNeuroniosCamadaIntermediaria, Integer nrNeuroniosCamadaSaida) {
		this.camadaIntermediaria = new Camada(nrNeuroniosCamadaIntermediaria, nrEntradas);
		this.camadaSaida = new Camada(nrNeuroniosCamadaSaida, nrNeuroniosCamadaIntermediaria);
	}

	public Double[] propagarSinais(Double entradas[]) {
		Double entradasUltimaCamada[] = this.camadaIntermediaria.propagarSinais(entradas);
		return this.camadaSaida.propagarSinais(entradasUltimaCamada);
	}
	
}