package edu.algo.sort;

import java.util.Arrays;

/**
 * O(n^2) time complexity - quadratic Unstable algorithm (order of duplicate values in array is NOT
 * guaranteed after the sort) Much faster than Insertion Sort because of a lot less element shifting
 */
public class D_ShellSort {

  public static void main(final String[] args) {
    final int[] array = {23, 5, -3, 12, -24, 54, -25, 78, 23, -43, 67};

    for (int gap = array.length / 2; gap > 0; gap /= 2) {
      for (int i = gap; i < array.length; i++) {
        int newElem = array[i];

        int j = i;
        while (j >= gap && array[j - gap] > newElem) {
          array[j] = array[j - gap];
          j -= gap;
        }

        array[j] = newElem;
      }
    }

    System.out.println(Arrays.toString(array));
  }
}
