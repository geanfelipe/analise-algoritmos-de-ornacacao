package aps;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AnaliseSelectionSort extends Analise {
	
	public AnaliseSelectionSort() {
		super("SelectionSort");
	}
	
	// Driver code to test above
	public static void main(final String args[]) {
		
		Map<Integer, List<int[]>> vetoresAleatorios = GeradorVetoresAleatorios.gerarVetoresInteiros();
		AnaliseSelectionSort analiseSelectionSort = new AnaliseSelectionSort();
		 for(Entry<Integer, List<int[]>> mapaComOsValores : vetoresAleatorios.entrySet()) {
			 Integer tamanhoDoVetor = mapaComOsValores.getKey();
			 List<int[]> listaCom50VetoresDeNPosicoes = mapaComOsValores.getValue();
			 
				for (int[] vetor: listaCom50VetoresDeNPosicoes) {
					analiseSelectionSort.sort(vetor);
				}
				Integer comparacoes = analiseSelectionSort.comparacoesPorTamanhoDoVetor.get(tamanhoDoVetor);
				double mediaDeComparacoes = comparacoes/tamanhoDoVetor;
				System.out.println("Testado algoritmo "+  analiseSelectionSort.nomeDoAlgoritmo +" para valores de tamanho "+tamanhoDoVetor + " ocorreu "+comparacoes+" comparacoes que em média ficou "+mediaDeComparacoes);
		 }
	}

	// Prints the array
	static void printArray(final int arr[]) {
		final int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	void sort(final int arr[]) {
		final int n = arr.length;

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				
				if (arr[j] < arr[min_idx]) {
					min_idx = j;
					this.comparacoesPorTamanhoDoVetor.compute(n, (tamanhoDoVetor,trocas) -> trocas == null ? 1 : trocas + 1);
				}

			// Swap the found minimum element with the first
			// element
			final int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}

	@Override
	void sort(float[] arr) {
		// TODO Auto-generated method stub
		
	}

}
