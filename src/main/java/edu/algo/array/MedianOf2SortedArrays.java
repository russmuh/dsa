package edu.algo.array;

/**
 * <pre>
 *
 * Median of Two Sorted Arrays
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 *
 * </pre>
 */
public class MedianOf2SortedArrays {

  public static void main(final String[] args) {
    System.out.println(findMedianSortedArrays(new int[] {1, 3}, new int[] {2})); // 2.0
    System.out.println(findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4})); // 2.5
    System.out.println(findMedianSortedArrays(new int[] {9, 66, 68, 77}, new int[] {3, 48, 65, 78, 80})); // 66
    System.out.println(findMedianSortedArrays(new int[] {1, 99, 100}, new int[] {6})); // 52.5
  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length == 0) {
      return calculateMedian(nums2);
    }

    if (nums2.length == 0) {
      return calculateMedian(nums1);
    }

    int[] array = new int[nums1.length + nums2.length];

    int total = 0;
    for (int i = 0; i <= array.length / 2; i++) {
      if (nums1.length > i) {
        resortArray(0, nums1[i], array, total++);
      }

      if (nums2.length > i) {
        resortArray(0, nums2[i], array, total++);
      }
    }

    return calculateMedian(array);
  }

  private static int[] resortArray(int i, int num, int[] array, int end) {
    if (i == end) {
      array[i] = num;
      return array;
    }

    if (array[i] > num) {
      int swap = array[i];
      array[i] = num;
      return resortArray(i + 1, swap, array, end);
    }

    return resortArray(i + 1, num, array, end);
  }

  private static double calculateMedian(final int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }

    int mid = nums.length / 2;
    if (nums.length % 2 == 0) {
      return (double) (nums[mid - 1] + nums[mid]) / 2;
    } else {
      return nums[mid];
    }
  }
}
