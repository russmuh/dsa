package edu.algo.array;

import java.util.Arrays;

/**
 * Third largest element in an array of distinct elements
 *
 * <pre>
 * Given an array of n integers, find the third largest element. All the elements in the array are distinct integers.
 * Example :
 *
 * Input: arr[] = {1, 14, 2, 16, 10, 20}
 * Output: The third Largest element is 14
 *
 * Explanation: Largest element is 20, second largest element is 16
 * and third largest element is 14
 *
 * Input: arr[] = {19, -10, 20, 14, 2, 16, 10}
 * Output: The third Largest element is 16
 *
 * Explanation: Largest element is 20, second largest element is 19
 * and third largest element is 16
 * </pre>
 */
public class ThirdLargestElem {

  public static void main(final String[] args) {
    final int[] elems = new int[] {5, 1, 2, 3, 4, 34, 6, 7, 345, 23, 57, 88, 545};

    System.out.println(Arrays.toString(thirdLargestElem(elems)));
  }

  private static int[] thirdLargestElem(final int[] elems) {
    if (elems.length < 3) {
      return null;
    }

    int first = elems[0], second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;

    for (int i = 0; i < elems.length; i++) {
      int elem = elems[i];

      if (first < elem) {
        third = second;
        second = first;
        first = elem;
      } else if (second < elem) {
        third = second;
        second = elem;
      } else if (third < elem) {
        third = elem;
      }
    }

    return new int[] {first, second, third};
  }
}
