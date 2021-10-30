package aps;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AnaliseMergeSort extends Analise{
	
	public AnaliseMergeSort() {
		super("MergeSort");
	}

	// Driver code
	public static void main(final String args[]) {
		Map<Integer, List<int[]>> vetoresAleatorios = GeradorVetoresAleatorios.gerarVetoresInteiros();
		AnaliseMergeSort analiseMergeSort = new AnaliseMergeSort();
		
		 for(Entry<Integer, List<int[]>> mapaComOsValores : vetoresAleatorios.entrySet()) {
			 Integer tamanhoDoVetor = mapaComOsValores.getKey();
			 List<int[]> listaCom50VetoresDeNPosicoes = mapaComOsValores.getValue();
			 
				for (int[] vetor: listaCom50VetoresDeNPosicoes) {
					analiseMergeSort.sort(vetor);
				}
				Integer comparacoes = analiseMergeSort.comparacoesPorTamanhoDoVetor.get(tamanhoDoVetor);
				double mediaDeComparacoes = comparacoes/tamanhoDoVetor;
				System.out.println("Testado algoritmo "+analiseMergeSort.nomeDoAlgoritmo+"para valores de tamanho "+tamanhoDoVetor + " ocorreu "+comparacoes+" comparacoes que em média ficou "+mediaDeComparacoes);
		 }
	}

	 void merge(final int arr[], final int l, final int m, final int r) {
		// Find sizes of two subarrays to be merged
		final int n1 = m - l + 1;
		final int n2 = r - m;

		/* Create temp arrays */
		final int L[] = new int[n1];
		final int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			this.comparacoesPorTamanhoDoVetor.compute(arr.length, (tamanhoDoVetor,trocas) -> trocas == null ? 1 : trocas + 1);
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
			this.comparacoesPorTamanhoDoVetor.compute(arr.length, (tamanhoDoVetor,trocas) -> trocas == null ? 1 : trocas + 1);
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
			this.comparacoesPorTamanhoDoVetor.compute(arr.length, (tamanhoDoVetor,trocas) -> trocas == null ? 1 : trocas + 1);
		}
	}

	/* A utility function to print array of size n */
	 void printArray(final int arr[]) {
		final int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Main function that sorts arr[l..r] using
	// merge()
	 void mergeSort(final int arr[], final int l, final int r) {
		if (l < r) {
			// Find the middle point
			final int m = l + (r - l) / 2;

			// Sort first and second halves
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	@Override
	void sort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	@Override
	void sort(float[] arr) {
		// TODO Auto-generated method stub
		
	}
}
