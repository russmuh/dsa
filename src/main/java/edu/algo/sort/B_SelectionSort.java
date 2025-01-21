package edu.algo.sort;

import java.util.Arrays;

/**
 * O(n^2) time complexity - quadratic
 * Unstable algorithm (order of duplicate values in array is NOT guaranteed after the sort)
 * Faster than Bubble Sort because of fewer swaps
 */
public class B_SelectionSort {

  public static void main(final String[] args) {
    int[] array = {1, 45, 6, 23, 45, 3, -8, -45, 67, -9, 87};

    for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
      int maxIndex = 0;
      for (int i = 1; i <= lastUnsortedIndex; i++) {
        if (array[i] > array[maxIndex]) {
          maxIndex = i;
        }
      }

      swap(array, maxIndex, lastUnsortedIndex);
    }

    System.out.println(Arrays.toString(array));
  }

  private static void swap(int[] array, int i, int j) {
    if (i == j) {
      return;
    }

    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
