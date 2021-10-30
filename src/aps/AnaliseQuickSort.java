package aps;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AnaliseQuickSort extends Analise {
	
	public AnaliseQuickSort() {
		super("QuickSort");
	}

	// Driver Code
	public static void main(final String[] args) {
		Map<Integer, List<int[]>> vetoresAleatorios = GeradorVetoresAleatorios.gerar();
		AnaliseQuickSort analiseQuickSort = new AnaliseQuickSort();
		
		 for(Entry<Integer, List<int[]>> mapaComOsValores : vetoresAleatorios.entrySet()) {
			 Integer tamanhoDoVetor = mapaComOsValores.getKey();
			 List<int[]> listaCom50VetoresDeNPosicoes = mapaComOsValores.getValue();
			 
				for (int[] vetor: listaCom50VetoresDeNPosicoes) {
					analiseQuickSort.sort(vetor);
				}
				Integer comparacoes = analiseQuickSort.comparacoesPorTamanhoDoVetor.get(tamanhoDoVetor);
				double mediaDeComparacoes = comparacoes/tamanhoDoVetor;
				System.out.println("Testado algoritmo "+analiseQuickSort.nomeDoAlgoritmo+"para valores de tamanho "+tamanhoDoVetor + " ocorreu "+comparacoes+" comparacoes que em média ficou "+mediaDeComparacoes);
		 }
	}

	/*
	 * This function takes last element as pivot, places the pivot element at its
	 * correct position in sorted array, and places all smaller (smaller than pivot)
	 * to left of pivot and all greater elements to right of pivot
	 */
	 int partition(final int[] arr, final int low, final int high) {

		// pivot
		final int pivot = arr[high];

		// Index of smaller element and
		// indicates the right position
		// of pivot found so far
		int i = (low - 1);

		for (int j = low; j <= high - 1; j++) {

			// If current element is smaller
			// than the pivot
			if (arr[j] < pivot) {

				// Increment index of
				// smaller element
				i++;
				swap(arr, i, j);
				this.comparacoesPorTamanhoDoVetor.compute(arr.length, (tamanhoDoVetor,trocas) -> trocas == null ? 1 : trocas + 1);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}

	// Function to print an array
	void printArray(final int[] arr, final int size) {
		for (int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");

		System.out.println();
	}

	/*
	 * The main function that implements QuickSort arr[] --> Array to be sorted, low
	 * --> Starting index, high --> Ending index
	 */
	void quickSort(final int[] arr, final int low, final int high) {
		if (low < high) {

			// pi is partitioning index, arr[p]
			// is now at right place
			final int pi = partition(arr, low, high);

			// Separately sort elements before
			// partition and after partition
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

	// A utility function to swap two elements
	 void swap(final int[] arr, final int i, final int j) {
		final int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	@Override
	void sort(int[] arr) {
		int n = arr.length;
		quickSort(arr, 0, n - 1);
		
	}
}
