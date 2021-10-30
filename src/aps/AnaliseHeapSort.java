package aps;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AnaliseHeapSort extends Analise {
	
	public AnaliseHeapSort() {
		super("HeapSort");
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	void heapify(final int arr[], final int n, final int i) {
		int largest = i; // Initialize largest as root
		final int l = 2 * i + 1; // left = 2*i + 1
		final int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && arr[l] > arr[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest])
			largest = r;

		// If largest is not root
		if (largest != i) {
			final int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			this.comparacoesPorTamanhoDoVetor.compute(arr.length, (tamanhoDoVetor,trocas) -> trocas == null ? 1 : trocas + 1);
			
			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}

	// Driver code
	public static void main(final String args[]) {
		Map<Integer, List<int[]>> vetoresAleatorios = GeradorVetoresAleatorios.gerarVetoresInteiros();
		AnaliseHeapSort analiseHeapSort = new AnaliseHeapSort();
		
		 for(Entry<Integer, List<int[]>> mapaComOsValores : vetoresAleatorios.entrySet()) {
			 Integer tamanhoDoVetor = mapaComOsValores.getKey();
			 List<int[]> listaCom50VetoresDeNPosicoes = mapaComOsValores.getValue();
			 
				for (int[] vetor: listaCom50VetoresDeNPosicoes) {
					analiseHeapSort.sort(vetor);
				}
				Integer comparacoes = analiseHeapSort.comparacoesPorTamanhoDoVetor.get(tamanhoDoVetor);
				double mediaDeComparacoes = comparacoes/tamanhoDoVetor;
				System.out.println("Testado algoritmo "+analiseHeapSort.nomeDoAlgoritmo+"para valores de tamanho "+tamanhoDoVetor + " ocorreu "+comparacoes+" comparacoes que em média ficou "+mediaDeComparacoes);
		 }
	}

	/* A utility function to print array of size n */
	static void printArray(final int arr[]) {
		final int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	@Override
	void sort(final int arr[]) {
		final int n = arr.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		// One by one extract an element from heap
		for (int i = n - 1; i > 0; i--) {
			// Move current root to end
			final int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			// call max heapify on the reduced heap
			heapify(arr, i, 0);
		}
	}

	@Override
	void sort(float[] arr) {
		// TODO Auto-generated method stub
		
	}

}
