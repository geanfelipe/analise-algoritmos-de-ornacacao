package aps;

import java.util.HashMap;
import java.util.Map;

public abstract class Analise {

	Map<Integer, Integer> comparacoesPorTamanhoDoVetor= new HashMap<Integer, Integer>();
	
	String nomeDoAlgoritmo;
	
	public Analise(String nomeDoAlgoritmo) {
		this.nomeDoAlgoritmo =nomeDoAlgoritmo; 
	}
	
	abstract void sort(final int[] arr);
}
