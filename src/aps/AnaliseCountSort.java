package aps;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AnaliseCountSort extends Analise{
	
	public AnaliseCountSort() {
		super("CountSort");
	}
	// Driver method
	public static void main(final String args[]) {

		Map<Integer, List<int[]>> vetoresAleatorios = GeradorVetoresAleatorios.gerarVetoresInteiros();
		AnaliseCountSort analiseCountSort = new AnaliseCountSort();
		
		 for(Entry<Integer, List<int[]>> mapaComOsValores : vetoresAleatorios.entrySet()) {
			 Integer tamanhoDoVetor = mapaComOsValores.getKey();
			 List<int[]> listaCom50VetoresDeNPosicoes = mapaComOsValores.getValue();
			 
				for (int[] vetor: listaCom50VetoresDeNPosicoes) {
					analiseCountSort.sort(vetor);
				}
				Integer comparacoes = analiseCountSort.comparacoesPorTamanhoDoVetor.get(tamanhoDoVetor);
				double mediaDeComparacoes = comparacoes/tamanhoDoVetor;
				System.out.println("Testado algoritmo "+analiseCountSort.nomeDoAlgoritmo+"para valores de tamanho "+tamanhoDoVetor + " ocorreu "+comparacoes+" comparacoes que em média ficou "+mediaDeComparacoes);
		 }
		 
	}

	@Override
	void sort(final int[] arr) {
		final int n = arr.length;

		// The output character array that will have sorted arr
		final int[] output = new int[n];

		// Create a count array to store count of individual
		// characters and initialize count array as 0
		final int count[] = new int[256];
		for (int i = 0; i < 256; ++i)
			count[i] = 0;

		// store count of each character
		for (int i = 0; i < n; ++i)
			++count[arr[i]];

		// Change count[i] so that count[i] now contains actual
		// position of this character in output array
		for (int i = 1; i <= 255; ++i)
			count[i] += count[i - 1];
			this.comparacoesPorTamanhoDoVetor.compute(arr.length, (tamanhoDoVetor,trocas) -> trocas == null ? 1 : trocas + 1);

		// Build the output character array
		// To make it stable we are operating in reverse order.
		for (int i = n - 1; i >= 0; i--) {
			output[count[arr[i]] - 1] = arr[i];
			--count[arr[i]];
			this.comparacoesPorTamanhoDoVetor.compute(arr.length, (tamanhoDoVetor,trocas) -> trocas == null ? 1 : trocas + 1);
		}

		// Copy the output array to arr, so that arr now
		// contains sorted characters
		for (int i = 0; i < n; ++i)
			arr[i] = output[i];
			this.comparacoesPorTamanhoDoVetor.compute(arr.length, (tamanhoDoVetor,trocas) -> trocas == null ? 1 : trocas + 1);
	}
	@Override
	void sort(float[] arr) {
		// TODO Auto-generated method stub
		
	}

}
