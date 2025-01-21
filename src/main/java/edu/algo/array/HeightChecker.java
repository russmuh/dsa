package edu.algo.array;

import java.util.Arrays;

public class HeightChecker {

  public static void main(final String[] args) {
    final int[] heights = new int[] {5, 1, 2, 3, 4};

    final HeightChecker checker = new HeightChecker();
    System.out.println(checker.heightChecker(heights));
  }

  public int heightChecker(int[] heights) {
    int[] ordinary = new int[heights.length];
    for (int i = 0; i < heights.length; i++) {
      ordinary[i] = heights[i];
    }

    int temp;
    for (int i = 0; i < heights.length; i++) {
      for (int j = i + 1; j < heights.length; j++) {
        if (heights[i] > heights[j]) {
          temp = heights[i];
          heights[i] = heights[j];
          heights[j] = temp;
        }
      }
    }

    System.out.println(Arrays.toString(ordinary));
    System.out.println(Arrays.toString(heights));

    int counter = 0;

    for (int i = 0; i < heights.length; i++) {
      if (heights[i] != ordinary[i]) {
        counter++;
      }
    }

    return counter;
  }
}
