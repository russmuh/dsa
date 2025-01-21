package edu.algo.sort;

import java.util.Arrays;

/**
 * O(n^2) time complexity - quadratic
 * Stable algorithm (order of duplicate values in array is guaranteed after the sort)
 * Slower than Selection Sort because of swaps in each step
 */
public class A_BubbleSort {

  public static void main(final String[] args) {
    /*int[] array = new int[] {4, 3, 1, 6, 8, 4, 23, 0, 53, 12};

    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[i] > array[j]) {
          int temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
      }
    }*/

    int[] array = {4, 2, -8, 5, -9, 33, 99, -8, -76, 55, 23, 45};

    for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
      for (int i = 0; i < lastUnsortedIndex; i++) {
        if (array[i] > array[i + 1]) {
          swap(array, i, i + 1);
        }
      }
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
