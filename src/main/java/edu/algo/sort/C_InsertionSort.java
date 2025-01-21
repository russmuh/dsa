package edu.algo.sort;

import java.util.Arrays;

/**
 * O(n^2) time complexity - quadratic
 * Stable algorithm (order of duplicates in array is guaranteed after the sort)
 * Keeps shifting elements to the right until it finds the current element's position
 */
public class C_InsertionSort {

  public static void main(final String[] args) {
    int[] array = {-3, 34, 5, 21, -45, -34, 95, 66, -54, 23};

    for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
      int newElement = array[firstUnsortedIndex];

      int i;
      for (i = firstUnsortedIndex; i > 0 && array[i - 1] > newElement; i--) {
        array[i] = array[i - 1];
      }

      array[i] = newElement;
    }

    System.out.println(Arrays.toString(array));
  }
}
