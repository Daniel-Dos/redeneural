package br.com.dextra.redeneural.classes;

import org.junit.Assert;
import org.junit.Test;

public class TestCamada {

	@Test
	public void testPropagarSinais() {
		Camada camada = new FakeCamada(2, 3);
		Double saida[] = camada.propagarSinais(new Double[] { 0d, 0d, 1d });
		Assert.assertArrayEquals(new Double[]{1d, 1d}, saida);
	}
	
	private class FakeCamada extends Camada {
		public FakeCamada(Integer nrNeuronios, Integer nrConexoesEntrada) {
			super(nrNeuronios, nrConexoesEntrada);
		}
		
		@Override
		protected void inicializarNeuronios(Integer nrConexoesEntrada) {
			TestNeuronio testNeuronio = new TestNeuronio();
			for (int i = 0; i < neuronios.length; i++) {
				neuronios[i] = testNeuronio.new FakeNeuronio(nrConexoesEntrada);
			}
		}
	}
	
}