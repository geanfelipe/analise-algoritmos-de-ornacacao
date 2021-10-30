package aps;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AnaliseBubleSort extends Analise {
	
	public AnaliseBubleSort() {
		super("BubleSort");
	}

	public static void main(final String[] args) {
		
		Map<Integer, List<int[]>> vetoresAleatorios = GeradorVetoresAleatorios.gerar();
		AnaliseBubleSort analiseBubleSort = new AnaliseBubleSort();
		
		 for(Entry<Integer, List<int[]>> mapaComOsValores : vetoresAleatorios.entrySet()) {
			 Integer tamanhoDoVetor = mapaComOsValores.getKey();
			 List<int[]> listaCom50VetoresDeNPosicoes = mapaComOsValores.getValue();
			 
				for (int[] vetor: listaCom50VetoresDeNPosicoes) {
					analiseBubleSort.sort(vetor);
				}
				Integer comparacoes = analiseBubleSort.comparacoesPorTamanhoDoVetor.get(tamanhoDoVetor);
				double mediaDeComparacoes = comparacoes/tamanhoDoVetor;
				System.out.println("Testado algoritmo "+analiseBubleSort.nomeDoAlgoritmo+"para valores de tamanho "+tamanhoDoVetor + " ocorreu "+comparacoes+" comparacoes que em média ficou "+mediaDeComparacoes);
		 }
	}

	@Override
	void sort(final int[] arr) {
		final int n = arr.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					// swap elements
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
					this.comparacoesPorTamanhoDoVetor.compute(n, (tamanhoDoVetor,trocas) -> trocas == null ? 1 : trocas + 1);
				}

			}
		}		
	}

}
