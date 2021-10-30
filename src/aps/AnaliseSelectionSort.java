package aps;

public class AnaliseSelectionSort {
	// Driver code to test above
	public static void main(final String args[]) {
		final int arr[] = { 64, 25, 12, 22, 11 };
		sort(arr);
		System.out.println("Sorted array");
		printArray(arr);
	}

	// Prints the array
	static void printArray(final int arr[]) {
		final int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	static void sort(final int arr[]) {
		final int n = arr.length;

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (arr[j] < arr[min_idx])
					min_idx = j;

			// Swap the found minimum element with the first
			// element
			final int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}

}
