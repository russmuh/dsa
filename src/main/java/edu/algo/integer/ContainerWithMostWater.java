package edu.algo.integer;

/**
 * 11. Container With Most Water
 *
 * <pre>
 * You are given an integer array height of length n. There are n vertical lines drawn such that
 * the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 * Example 1:
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case,
 * the max area of water (blue section) the container can contain is 49.
 *
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 * </pre>
 */
public class ContainerWithMostWater {

  public static void main(final String[] args) {
    //    final int[] array = {1,1};
    final int[] array = {1,8,6,2,5,4,8,3,7};

    System.out.println(maxArea(array));
  }

  public static int maxArea(int[] height) {
    int length = height.length;

    int maxArea = 0;

    int i = 0;
    int j = length - 1;

    // [1, 1]
    // [4, 2, 5, 1]
    // [1, 8, 6, 2, 5, 4, 8, 3, 7]
    while (i < length) {
      if (i == j) {
        break;
      }

      int h = Math.min(height[i], height[j]);
      int w = j - i;

      int area = h * w;
      if (maxArea < area) {
        maxArea = area;
      }

      if (height[i] > height[j]) {
        j--;
      } else {
        i++;
      }
    }

    return maxArea;
  }
}
