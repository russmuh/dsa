package edu.algo.sort;

import java.util.Arrays;

/** O (n * log n) - time complexity */
public class F_MergeSort {

  public static void main(final String[] args) {
    int[] array = {12, 11, 13, 5, 6, 7};
    System.out.println("Unsorted array: " + Arrays.toString(array));

    sort(array, 0, array.length - 1);
    System.out.println("Sorted array: " + Arrays.toString(array));
  }

  public static void sort(int[] array, int start, int end) {
    if (start < end) {
      // Find the middle point
      int mid = (start + end) / 2;

      // Sort the first half
      sort(array, start, mid);

      // Sort the second half
      sort(array, mid + 1, end);

      // Merge two sorted halves
      merge(array, start, mid, end);
    }
  }

  /**
   * <pre>
   * Merges two sub-arrays of array[]:
   * 1. The first sub-array: array[start, mid]
   * 2. The second sub-array: array[mid + 1, end]
   * </pre>
   */
  private static void merge(int[] array, int start, int mid, int end) {
    // Define two temp sub-arrays
    int[] left = new int[(mid + 1) - start];
    int[] right = new int[end - mid];

    // Copy the first half of array into left array
    for (int i = 0; i < left.length; i++) {
      left[i] = array[start + i];
    }

    // Copy the second half of array into right array
    for (int j = 0; j < right.length; j++) {
      right[j] = array[(mid + 1) + j];
    }

    // Initial indices of the first and second sub-arrays
    int i = 0, j = 0;

    // Initial index of merged sub-array
    int k = start;

    // Merge sub-arrays
    while (i < left.length && j < right.length) {
      if (left[i] <= right[j]) {
        array[k++] = left[i++];
      } else {
        array[k++] = right[j++];
      }
    }

    while (i < left.length) {
      array[k++] = left[i++];
    }

    while (j < right.length) {
      array[k++] = right[j++];
    }
  }
}
