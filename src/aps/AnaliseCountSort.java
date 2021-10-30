package aps;

public class AnaliseCountSort {
	// Driver method
	public static void main(final String args[]) {
		final int[] arr = { 14, 1, 4, 1, 2, 7, 5, 2, 10, 12, 11, 10, 12 };

		sort(arr);

		System.out.print("Sorted character array is ");
		for (int i = 0; i < arr.length; ++i)
			System.out.println(arr[i]);
	}

	// Java implementation of Counting Sort
	static void sort(final int[] arr) {
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

		// Build the output character array
		// To make it stable we are operating in reverse order.
		for (int i = n - 1; i >= 0; i--) {
			output[count[arr[i]] - 1] = arr[i];
			--count[arr[i]];
		}

		// Copy the output array to arr, so that arr now
		// contains sorted characters
		for (int i = 0; i < n; ++i)
			arr[i] = output[i];
	}

}
