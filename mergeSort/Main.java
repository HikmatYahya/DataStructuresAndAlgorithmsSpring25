package mergeSort;

import java.util.Arrays;

public class Main {

    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return; // Base case: already sorted or empty
        }

        int mid = array.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[array.length - mid];

        // Split the array into two halves
        for (int i = 0; i < mid; i++) {
            leftArray[i] = array[i];
        }

        for (int i = mid; i < array.length; i++) {
            rightArray[i - mid] = array[i];
        }

        // Recursively sort the two halves
        mergeSort(leftArray);
        mergeSort(rightArray);

        // Merge the sorted halves
        merge(leftArray, rightArray, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] mergedArray) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int i = 0; // leftArray
        int j = 0; // rightArray
        int k = 0; // Index for mergedArray

        // Compare elements from leftArray and rightArray and merge them in sorted order
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                mergedArray[k++] = leftArray[i++];
            } else {
                mergedArray[k++] = rightArray[j++];
            }
        }

        // Copy any remaining elements from leftArray
        while (i < leftSize) {
            mergedArray[k++] = leftArray[i++];
        }

        // Copy any remaining elements from rightArray
        while (j < rightSize) {
            mergedArray[k++] = rightArray[j++];
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 3, 6, 2, 1, 8, 5, 4, 7};
        System.out.println("Before sorting: " + Arrays.toString(array));

        mergeSort(array);

        System.out.println("After sorting: " + Arrays.toString(array));
    }
}
