package aps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class AnaliseRadixSort {
	
	public Map<Integer, Integer> comparacoesPorTamanhoDoVetor= new HashMap<Integer, Integer>();

	void countSort(final int arr[], final int n, final int exp) {
		final int output[] = new int[n]; // output array
		int i;
		final int count[] = new int[10];
		Arrays.fill(count, 0);

		for (i = 0; i < n; i++)
			count[(arr[i] / exp) % 10]++;

		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
			this.comparacoesPorTamanhoDoVetor.compute(n, (tamanhoDoVetor,trocas) -> trocas == null ? 1 : trocas + 1);
		}

		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}

	static int getMax(final int arr[], final int n) {
		int mx = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > mx)
				mx = arr[i];
		return mx;
	}

	public static void main(final String[] args) {
		Map<Integer, List<int[]>> vetoresAleatorios = gerar50VetoresAleatoriosComTamanhosDefinidos();
		AnaliseRadixSort analiseRadixSort = new AnaliseRadixSort();
		 for(Entry<Integer, List<int[]>> mapaComOsValores : vetoresAleatorios.entrySet()) {
			 Integer tamanhoDoVetor = mapaComOsValores.getKey();
			 List<int[]> listaCom50VetoresDeNPosicoes = mapaComOsValores.getValue();
			 
				for (int[] vetor: listaCom50VetoresDeNPosicoes) {
					final int tamanho = vetor.length;
					analiseRadixSort.radixsort(vetor, tamanho);
//					print(vetor, tamanho);
				}
				Integer comparacoes = analiseRadixSort.comparacoesPorTamanhoDoVetor.get(tamanhoDoVetor);
				double mediaDeComparacoes = comparacoes/tamanhoDoVetor;
				System.out.println("Testado para valores de tamanho "+tamanhoDoVetor + " ocorreu "+comparacoes+" comparacoes que em média ficou "+mediaDeComparacoes);
		 }
		
//		final int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
//		final int n = arr.length;
//
//		radixsort(arr, n);
//		print(arr, n);
	}

	static void print(final int arr[], final int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	void radixsort(final int arr[], final int n) {
		final int m = getMax(arr, n);

		for (int exp = 1; m / exp > 0; exp *= 10)
			this.countSort(arr, n, exp);
	}

	static Map<Integer, List<int[]>> gerar50VetoresAleatoriosComTamanhosDefinidos() {
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
