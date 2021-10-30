package aps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GeradorVetoresAleatorios {

	static Map<Integer, List<int[]>> gerar() {
		final Map<Integer, List<int[]>> valoresAleatorios = new HashMap<Integer, List<int[]>>();
		final int[] tamanhoDosVetores = { 5, 10, 50, 100, 1000, 10000 };
		
		for (final int tamanhoDoVetor : tamanhoDosVetores) {
			
			List<int[]> vetores = new ArrayList<int[]>();
			
			int crie50Vetores=0;
			while (crie50Vetores<50) {
				
				final int[] vetorDeNPosicoes = new int[tamanhoDoVetor];
				
				for (int indice = 0; indice < tamanhoDoVetor; indice++) {
					final Random rand = new Random();
					final int upperbound = 50;
					final int valorAleatorio = rand.nextInt(upperbound);
					
					vetorDeNPosicoes[indice] = valorAleatorio;
				}
				
				vetores.add(vetorDeNPosicoes);
				
				crie50Vetores++;
			}
			valoresAleatorios.put(tamanhoDoVetor, vetores);
		}

		return valoresAleatorios;
	}
}
