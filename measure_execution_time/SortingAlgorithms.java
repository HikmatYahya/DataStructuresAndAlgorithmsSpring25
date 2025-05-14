package measure_execution_time;


import java.util.Random;

public class SortingAlgorithms {

	public static void main(String[] args) {
		int[] smallDataSet = generateDataSet(1000);
		int[] mediumDataSet = generateDataSet(10000);
		int[] largeDataSet = generateDataSet(50000);

		long bubbleSortSmallTime = measureExecutionTime(smallDataSet, "Bubble Sort");
		long bubbleSortMediumTime = measureExecutionTime(mediumDataSet, "Bubble Sort");
		long bubbleSortLargeTime = measureExecutionTime(largeDataSet, "Bubble Sort");

		long insertionSortSmallTime = measureExecutionTime(smallDataSet, "Insertion Sort");
		long insertionSortMediumTime = measureExecutionTime(mediumDataSet, "Insertion Sort");
		long insertionSortLargeTime = measureExecutionTime(largeDataSet, "Insertion Sort");

		long selectionSortSmallTime = measureExecutionTime(smallDataSet, "Selection Sort");
		long selectionSortMediumTime = measureExecutionTime(mediumDataSet, "Selection Sort");
		long selectionSortLargeTime = measureExecutionTime(largeDataSet, "Selection Sort");

		System.out.println("Bubble Sort Execution Times:");
		System.out.println("Small DataSet: " + bubbleSortSmallTime + " ms");
		System.out.println("Medium DataSet: " + bubbleSortMediumTime + " ms");
		System.out.println("Large DataSet: " + bubbleSortLargeTime + " ms");

		System.out.println("\nInsertion Sort Execution Times:");
		System.out.println("Small DataSet: " + insertionSortSmallTime + " ms");
		System.out.println("Medium DataSet: " + insertionSortMediumTime + " ms");
		System.out.println("Large DataSet: " + insertionSortLargeTime + " ms");

		System.out.println("\nSelection Sort Execution Times:");
		System.out.println("Small DataSet: " + selectionSortSmallTime + " ms");
		System.out.println("Medium DataSet: " + selectionSortMediumTime + " ms");
		System.out.println("Large DataSet: " + selectionSortLargeTime + " ms");
	}

	public static int[] generateDataSet(int size) {
		int[] dataSet = new int[size];
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			dataSet[i] = random.nextInt(1000); // Generate random numbers between 0 and 999
		}
		return dataSet;
	}

	public static long measureExecutionTime(int[] dataSet, String algorithm) {
		long startTime = System.currentTimeMillis();
		switch (algorithm) {
		case "Bubble Sort":
			bubbleSort(dataSet);
			break;
		case "Insertion Sort":
			insertionSort(dataSet);
			break;
		case "Selection Sort":
			selectionSort(dataSet);
			break;
		}
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

	public static void bubbleSort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (array[j] > array[j + 1]) {

					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	public static void insertionSort(int[] array) {
		int n = array.length;
		for (int i = 1; i < n; ++i) {
			int key = array[i];
			int j = i - 1;

			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
	}

	public static void selectionSort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}

			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
	}

	public static void mergeSort(int[] array) {
		if (array.length > 1) {
			int mid = array.length / 2;
			int[] left = new int[mid];
			int[] right = new int[array.length - mid];

			// Copy elements to left array
			for (int i = 0; i < mid; i++) {
				left[i] = array[i];
			}

			// Copy elements to right array
			for (int i = mid; i < array.length; i++) {
				right[i - mid] = array[i];
			}

			// Recursive calls
			mergeSort(left);
			mergeSort(right);

			// Merge
			int i = 0, j = 0, k = 0;
			while (i < left.length && j < right.length) {
				if (left[i] < right[j]) {
					array[k++] = left[i++];
				} else {
					array[k++] = right[j++];
				}
			}

			// Copy remaining elements of left array
			while (i < left.length) {
				array[k++] = left[i++];
			}

			// Copy remaining elements of right array
			while (j < right.length) {
				array[k++] = right[j++];
			}
		}
	}
}