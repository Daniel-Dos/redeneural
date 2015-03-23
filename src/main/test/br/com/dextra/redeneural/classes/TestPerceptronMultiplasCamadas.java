package br.com.dextra.redeneural.classes;

import org.junit.Test;

public class TestPerceptronMultiplasCamadas {

	// TODO testar.
	@Test
	public void testPropagarSinais() {
		PerceptronMultiplasCamadas mlp = new PerceptronMultiplasCamadas(4, 3, 2);
		Double sinal[] = mlp.propagarSinais(new Double[] { 1d, 1d, 1d, 1d });
	}

}