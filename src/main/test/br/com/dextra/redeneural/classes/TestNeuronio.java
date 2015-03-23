package br.com.dextra.redeneural.classes;
import org.junit.Assert;
import org.junit.Test;

import br.com.dextra.redeneural.classes.Neuronio;

public class TestNeuronio {

	@Test
	public void testPropagarSinais() {
		Neuronio neuronio = new FakeNeuronio(2);
		Double sinal = neuronio.propagarSinais(new Double[] {0d, 1d});
		Assert.assertEquals(new Double(1), sinal);
	}
	
	class FakeNeuronio extends Neuronio {
		public FakeNeuronio(Integer nrConexoesEntrada) {
			super(nrConexoesEntrada);
		}
		
		@Override
		protected void inicializarConexoes() {
			for (int i = 0; i < conexoes.length; i++) {
				conexoes[i] = 1d;
			}
		}
	}
	
}