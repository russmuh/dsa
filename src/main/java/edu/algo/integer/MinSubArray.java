package edu.algo.integer;

import java.util.Arrays;

/**
 * 209. Minimum Size Subarray Sum
 *
 * <pre>
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 *  whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 *
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 * </pre>
 */
public class MinSubArray {

  public static void main(final String[] args) {
    final int[] array = {12,28,83,4,25,26,25,2,25,25,25,12};

    System.out.println(minSubArrayLen(213, array));
  }

  public static int minSubArrayLen(int target, int[] nums) {
    int length = nums.length; // The length of the input array.
    long sum = 0; // The sum of the current subarray.
    int minLength = length + 1; // Initialize minLength with max possible value plus one for comparison.

    // [2,3,1,2,4,3]
    // Two pointers method: i is the end-pointer, j is the start-pointer of the sliding window.
    for (int end = 0, start = 0; end < length; end++) {
      sum += nums[end]; // Increment the sum by the current element value.

      // Shrink the window from the left until the sum is smaller than the target.
      // This finds the smallest window that ends at position 'end'.
      while (start < length && sum >= target) {
        minLength = Math.min(minLength, end - start + 1); // Update minLength if a smaller length is found.
        sum -= nums[start++]; // Decrease the sum by the start-value and increment start-pointer to shrink the window.
      }
    }

    // If minLength is updated (smaller than n + 1), we found a valid subarray.
    // Otherwise, return 0 as a subarray meeting the conditions is not found.
    return minLength <= length ? minLength : 0;
  }
}
