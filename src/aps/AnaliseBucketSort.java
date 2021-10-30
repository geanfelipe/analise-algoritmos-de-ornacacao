package aps;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.Map.Entry;

public class AnaliseBucketSort extends Analise {
	
	public AnaliseBucketSort() {
		super("BucketSort");
	}

	// Function to sort arr[] of size n
	// using bucket sort
	void bucketSort(final float arr[], final int n) {
		if (n <= 0)
			return;

		// 1) Create n empty buckets
		@SuppressWarnings("unchecked")
		final Vector<Float>[] buckets = new Vector[n];

		for (int i = 0; i < n; i++) {
			buckets[i] = new Vector<Float>();
		}

		// 2) Put array elements in different buckets
		for (int i = 0; i < n; i++) {
			final float idx = arr[i] * n;
			buckets[(int) idx].add(arr[i]);
		}

		// 3) Sort individual buckets
		for (int i = 0; i < n; i++) {
			Collections.sort(buckets[i]);
		}

		// 4) Concatenate all buckets into arr[]
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < buckets[i].size(); j++) {
				arr[index++] = buckets[i].get(j);
				this.comparacoesPorTamanhoDoVetor.compute(arr.length, (tamanhoDoVetor,trocas) -> trocas == null ? 1 : trocas + 1);
			}
		}
	}

	// Driver code
	public static void main(final String args[]) {
		final float arr[] = { (float) 0.897, (float) 0.565, (float) 0.656, (float) 0.1234, (float) 0.665,
				(float) 0.3434 };
		
		Map<Integer, List<float[]>> vetoresAleatorios = GeradorVetoresAleatorios.gerarVetoresDecimais();
		AnaliseBucketSort analiseBucketSort = new AnaliseBucketSort();
		
		 for(Entry<Integer, List<float[]>> mapaComOsValores : vetoresAleatorios.entrySet()) {
			 Integer tamanhoDoVetor = mapaComOsValores.getKey();
			 List<float[]> listaCom50VetoresDeNPosicoes = mapaComOsValores.getValue();
			 
				for (float[] vetor: listaCom50VetoresDeNPosicoes) {
					analiseBucketSort.sort(vetor);
				}
				Integer comparacoes = analiseBucketSort.comparacoesPorTamanhoDoVetor.get(tamanhoDoVetor);
				double mediaDeComparacoes = comparacoes/tamanhoDoVetor;
				System.out.println("Testado algoritmo "+analiseBucketSort.nomeDoAlgoritmo+"para valores de tamanho "+tamanhoDoVetor + " ocorreu "+comparacoes+" comparacoes que em média ficou "+mediaDeComparacoes);
		 }

	}

	@Override
	void sort(int[] arr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void sort(float[] arr) {
		final int n = arr.length;
		bucketSort(arr, n);
	}
}
