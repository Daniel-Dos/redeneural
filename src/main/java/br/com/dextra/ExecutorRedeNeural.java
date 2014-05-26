package br.com.dextra;


public class ExecutorRedeNeural {

	private static double[][] CONJUNTO_TREINAMENTO = {
		{0.0, 0.0, 1.0, 1.0},
		{0.0, 1.0, 0.0, 1.0},
		{1.0, 1.0, 1.0, 1.0}
	};

	private static double[] VALORES_ESPERADOS = {0.0, 0.0, 0.0, 1.0};

	public static void main(String[] args) {

		int nrNeuroniosPrimeiraCamada = 3;
		int nrNeuroniosEntrada = 3;

		RedeNeural rede = new RedeNeural(nrNeuroniosPrimeiraCamada, nrNeuroniosEntrada);

		// TODO descomentar se quiser treinar.
		// -----------------------------------------------------------------------------------------------------
		rede.treinar(ExecutorRedeNeural.CONJUNTO_TREINAMENTO, ExecutorRedeNeural.VALORES_ESPERADOS);

		System.out.println("\n Conexoes da primeira camada:");
		double[][] conexoesPrimeiraCamada = rede.getConexoesPrimeiraCamada();
		for (int i = 0; i < conexoesPrimeiraCamada.length; i++) {
			for (int j = 0; j < conexoesPrimeiraCamada[i].length; j++) {
				System.out.println(conexoesPrimeiraCamada[i][j] + " ");
			}
			System.out.println("\n");
		}

		System.out.println("\n Conexoes da segunda camada:");
		double[] conexoesSegundaCamada = rede.getConexoesSegundaCamada();
		for (int i = 0; i < conexoesSegundaCamada.length; i++) {
			System.out.println(conexoesSegundaCamada[i] + " ");
		}

		System.out.println("\n\n");
		// -----------------------------------------------------------------------------------------------------

		// TODO comentar se quiser treinar.
		// -----------------------------------------------------------------------------------------------------
		/*double[][] conexoesPrimeiraCamada = {
			{-2.2879196278616676, -2.384950661869149, 3.138503770220556},
			{2.757224639358555, 2.6733843232446883, -3.7526551478417214}
		};

		double[] conexoesSegundaCamada = {-5.105177692290446, 6.2731389334582115, -1.4356657864516056};

		rede.setConexoesPrimeiraCamada(conexoesPrimeiraCamada);
		rede.setConexoesSegundaCamada(conexoesSegundaCamada);*/
		// -----------------------------------------------------------------------------------------------------

		rede.classificar(new double[] { 1.0, 1.0, 1.0 });

	}

}