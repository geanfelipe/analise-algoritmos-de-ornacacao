package aps;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AnaliseInsertionSort extends Analise{

	public AnaliseInsertionSort() {
		super("InsertionSort");
	}
	
	// Driver method
	public static void main(final String args[]) {
		final int arr[] = { 12, 11, 13, 5, 6 };

		Map<Integer, List<int[]>> vetoresAleatorios = GeradorVetoresAleatorios.gerar();
		AnaliseInsertionSort analiseInserionSort = new AnaliseInsertionSort();
		
		 for(Entry<Integer, List<int[]>> mapaComOsValores : vetoresAleatorios.entrySet()) {
			 Integer tamanhoDoVetor = mapaComOsValores.getKey();
			 List<int[]> listaCom50VetoresDeNPosicoes = mapaComOsValores.getValue();
			 
				for (int[] vetor: listaCom50VetoresDeNPosicoes) {
					analiseInserionSort.sort(vetor);
				}
				Integer comparacoes = analiseInserionSort.comparacoesPorTamanhoDoVetor.get(tamanhoDoVetor);
				double mediaDeComparacoes = comparacoes/tamanhoDoVetor;
				System.out.println("Testado algoritmo "+analiseInserionSort.nomeDoAlgoritmo+"para valores de tamanho "+tamanhoDoVetor + " ocorreu "+comparacoes+" comparacoes que em média ficou "+mediaDeComparacoes);
		 }
	}

	/* A utility function to print array of size n */
	 void printArray(final int arr[]) {
		final int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
	}

	@Override
	void sort(final int arr[]) {
		final int n = arr.length;
		for (int i = 1; i < n; ++i) {
			final int key = arr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

}
