package aps;

import java.util.Random;

public class Teste {
	public static void main(final String[] args) {
		final int[] tamanhoDosVetores = { 5, 10, 50, 100, 1000, 10000 };

		for (final int tamanhoDoVator : tamanhoDosVetores) {

			final Random rand = new Random(); // instance of random class
			final int upperbound = 25;
			final int int_random = rand.nextInt(upperbound);
			System.out.println(int_random);
		}

		final int[] ary = new int[10];

		for (int i = 0; i < ary.length; i++) {
			System.out.println("oi");
		}

	}
}
