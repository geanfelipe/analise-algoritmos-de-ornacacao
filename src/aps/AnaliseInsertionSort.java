package aps;

public class AnaliseInsertionSort {

	// Driver method
	public static void main(final String args[]) {
		final int arr[] = { 12, 11, 13, 5, 6 };

		sort(arr);

		printArray(arr);
	}

	/* A utility function to print array of size n */
	static void printArray(final int arr[]) {
		final int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
	}

	static void sort(final int arr[]) {
		final int n = arr.length;
		for (int i = 1; i < n; ++i) {
			final int key = arr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

}
