package edu.algo.integer;

import java.util.*;

/**
 * 3Sum
 * <pre>
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 * <pre/>
 */
public class ThreeSums {

  public static void main(final String[] args) {
    //    final int[] array = {-1, 0, 1, 2, -1, -4};
    final int[] array = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};

    System.out.println(triplets3(array));
  }

  /**
   * Time Complexity: O(N^3 * log(no. of unique triplets)), where N = size of the array. Reason:
   * Here, we are mainly using 3 nested loops. And inserting triplets into the set takes O(log(no.
   * of unique triplets)) time complexity. But we are not considering the time complexity of sorting
   * as we are just sorting 3 elements every time.
   *
   * <p>Space Complexity: O(2 * no. of the unique triplets) as we are using a set data structure and
   * a list to store the triplets.
   */
  public static List<List<Integer>> triplets(int[] nums) {
    Set<List<Integer>> st = new HashSet<>();

    // check all possible triplets:
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          if (nums[i] + nums[j] + nums[k] == 0) {
            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
            temp.sort(null); // it is to make sure duplicates are avoided
            st.add(temp);
          }
        }
      }
    }

    // store the set elements in the answer:
    return new ArrayList<>(st);
  }

  /**
   * Time Complexity: O(N2 * log(no. of unique triplets)), where N = size of the array. Reason:
   * Here, we are mainly using 3 nested loops. And inserting triplets into the set takes O(log(no.
   * of unique triplets)) time complexity. But we are not considering the time complexity of sorting
   * as we are just sorting 3 elements every time.
   *
   * <p>Space Complexity: O(2 * no. of the unique triplets) + O(N) as we are using a set data
   * structure and a list to store the triplets and extra O(N) for storing the array elements in
   * another set.
   */
  public static List<List<Integer>> triplets2(int[] nums) {
    Set<List<Integer>> st = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      Set<Integer> hashset = new HashSet<>();
      for (int j = i + 1; j < nums.length; j++) {
        // nums[i] + nums[j] + nums[k] = 0;
        // nums[k] = -(nums[i] + nums[j])
        // Calculate the 3rd element:
        int third = -(nums[i] + nums[j]);

        // Find the element in the set:
        if (hashset.contains(third)) {
          List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
          temp.sort(null);
          st.add(temp);
        }
        hashset.add(nums[j]);
      }
    }

    // store the set elements in the answer:
    return new ArrayList<>(st);
  }

  /**
   * Time Complexity: O(NlogN)+O(N2), where N = size of the array. Reason: The pointer i, is running
   * for approximately N times. And both the pointers j and k combined can run for approximately N
   * times including the operation of skipping duplicates. So the total time complexity will be
   * O(N2).
   *
   * <p>Space Complexity: O(no. of quadruplets), This space is only used to store the answer. We are
   * not using any extra space to solve this problem. So, from that perspective, space complexity
   * can be written as O(1).
   */
  public static List<List<Integer>> triplets3(int[] nums) {
    // Sort the array to make the two-pointer technique applicable
    Arrays.sort(nums);

    // Initialize the list to store the triplets
    List<List<Integer>> triplets = new ArrayList<>();

    // Get the length of the array
    int length = nums.length;

    // {-2, -1, 0, 0, 1, 2}
    // Iterate over the array, looking for the first element of the triplet
    for (int first = 0; first < length - 2 && nums[first] <= 0; first++) {
      // Skip duplicate elements to avoid duplicate triplets
      if (first > 0 && nums[first] == nums[first - 1]) {
        continue;
      }

      // Initialize the second and third pointers
      int second = first + 1;
      int third = length - 1;

      // Use two-pointer technique to find the remaining two elements
      while (second < third) {
        int sum = nums[first] + nums[second] + nums[third];

        if (sum < 0) { // If the sum is less than zero, move the second pointer to the right
          second++;
        } else if (sum > 0) { // If the sum is greater than zero, move the third pointer to the left
          third--;
        } else { // If the sum is zero, we've found a valid triplet
          triplets.add(List.of(nums[first], nums[second], nums[third]));

          // Move the second pointer to the right and skip duplicates
          while (second < third && nums[second] == nums[second + 1]) {
            second++;
          }

          // Move the third pointer to the left and skip duplicates
          while (second < third && nums[third] == nums[third - 1]) {
            third--;
          }

          // Move both pointers for the next potential triplet
          second++;
          third--;
        }
      }
    }
    // Return the list of triplets
    return triplets;
  }

  /**
   * Time Complexity: O(NlogN)+O(N2), where N = size of the array. Reason: The pointer i, is running
   * for approximately N times. And both the pointers j and k combined can run for approximately N
   * times including the operation of skipping duplicates. So the total time complexity will be
   * O(N2).
   *
   * <p>Space Complexity: O(no. of quadruplets), This space is only used to store the answer. We are
   * not using any extra space to solve this problem. So, from that perspective, space complexity
   * can be written as O(1).
   */
  public static List<List<Integer>> triplets3_1(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      // remove duplicates:
      if (i != 0 && nums[i] == nums[i - 1]) continue;

      // moving 2 pointers:
      int j = i + 1;
      int k = nums.length - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum < 0) {
          j++;
        } else if (sum > 0) {
          k--;
        } else {
          List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
          ans.add(temp);
          j++;
          k--;
          // skip the duplicates:
          while (j < k && nums[j] == nums[j - 1]) j++;
          while (j < k && nums[k] == nums[k + 1]) k--;
        }
      }
    }

    return ans;
  }
}
