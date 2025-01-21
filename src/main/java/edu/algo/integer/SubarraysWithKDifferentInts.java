package edu.algo.integer;

import java.util.HashMap;

/**
 * 992. Subarrays with K Different Integers
 *
 * <pre>
 * Given an integer array nums and an integer k, return the number of good subarrays of nums.
 *
 * A good array is an array where the number of different integers in that array is exactly k.
 *
 * For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
 * A subarray is a contiguous part of an array.
 *
 * Example 1:
 *
 * Input: nums = [1,2,1,2,3], k = 2
 * Output: 7
 * Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
 *
 * Example 2:
 *
 * Input: nums = [1,2,1,3,4], k = 3
 * Output: 3
 * Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i], k <= nums.length
 * </pre>
 */
public class SubarraysWithKDifferentInts {

  public static void main(final String[] args) {
    final int[] array = {2, 1, 2, 1, 6};

    System.out.println(subarraysWithKDistinct(array, 2)); // 7
  }

  static int subarraysWithKDistinct(int nums[], int k) {
    // declare a map for the frequency
    HashMap<Integer, Integer> mapp = new HashMap<>();
    int begin = 0, end = 0, prefix = 0, cnt = 0;
    int res = 0;

    // traverse the array
    while (end < nums.length) {
      // increase the frequency
      if (mapp.containsKey(nums[end])) {
        mapp.put(nums[end], mapp.get(nums[end]) + 1);
      } else {
        mapp.put(nums[end], 1);
      }
      if (mapp.get(nums[end]) == 1) {
        cnt++;
      }
      end++;
      if (cnt > k) {
        if (mapp.containsKey(nums[begin])) {
          mapp.put(nums[begin], mapp.get(nums[begin]) - 1);
        } else {
          mapp.put(nums[begin], -1);
        }
        begin++;
        cnt--;
        prefix = 0;
      }

      // loop until mapp[A[begin]] > 1
      while (mapp.get(nums[begin]) > 1) {
        if (mapp.containsKey(nums[begin])) {
          mapp.put(nums[begin], mapp.get(nums[begin]) - 1);
        } else {
          mapp.put(nums[begin], -1);
        }
        begin++;
        prefix++;
      }
      if (cnt == k) {
        res += prefix + 1;
      }
    }

    // return the final count
    return res;
  }
}
