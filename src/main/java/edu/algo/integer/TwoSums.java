package edu.algo.integer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum.
 * LEVEL: EASY
 *
 * <pre>
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * <pre/>
 */
public class TwoSums {

  public static void main(final String[] args) {
    final int[] array = {4, 2, 3, 1, 5};

    System.out.println(Arrays.toString(twoSum2(array, 7)));
  }

  /**
   * <pre>
   * Time complexity: O(n^2)
   * Space complexity: O(1)
   * <pre/>
   */
  public static int[] twoSum1(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] {i, j};
        }
      }
    }

    return null;
  }

  /**
   * <pre>
   * Time complexity: O(n)
   * Space complexity: O(n)
   * <pre/>
   */
  public static int[] twoSum2(int[] nums, int target) {
    final Map<Integer, Integer> indexMap = new HashMap<>();

    // nums = [2,7,11,15], target = 9
    for (int i = 0; i < nums.length; i++) {
      final Integer requiredNum = (target - nums[i]);

      if (indexMap.containsKey(requiredNum)) {
        return new int[] {indexMap.get(requiredNum), i};
      }

      indexMap.put(nums[i], i);
    }

    return null;
  }
}
