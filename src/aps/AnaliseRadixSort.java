package aps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AnaliseRadixSort extends Analise{
	
	public AnaliseRadixSort() {
		super("RadixSort");
	}
	
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
		Map<Integer, List<int[]>> vetoresAleatorios = GeradorVetoresAleatorios.gerarVetoresInteiros();
		AnaliseRadixSort analiseRadixSort = new AnaliseRadixSort();
		 for(Entry<Integer, List<int[]>> mapaComOsValores : vetoresAleatorios.entrySet()) {
			 Integer tamanhoDoVetor = mapaComOsValores.getKey();
			 List<int[]> listaCom50VetoresDeNPosicoes = mapaComOsValores.getValue();
			 
				for (int[] vetor: listaCom50VetoresDeNPosicoes) {
					analiseRadixSort.sort(vetor);
//					print(vetor, tamanho);
				}
				Integer comparacoes = analiseRadixSort.comparacoesPorTamanhoDoVetor.get(tamanhoDoVetor);
				double mediaDeComparacoes = comparacoes/tamanhoDoVetor;
				System.out.println("Testado algoritmo "+analiseRadixSort.nomeDoAlgoritmo+"para valores de tamanho "+tamanhoDoVetor + " ocorreu "+comparacoes+" comparacoes que em média ficou "+mediaDeComparacoes);
		 }
		
	}

	static void print(final int arr[], final int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	@Override
	void sort(int[] arr) {
		final int n = arr.length;
		final int m = getMax(arr, n);

		for (int exp = 1; m / exp > 0; exp *= 10)
			this.countSort(arr, n, exp);		
	}

	@Override
	void sort(float[] arr) {
		// TODO Auto-generated method stub
		
	}

}
