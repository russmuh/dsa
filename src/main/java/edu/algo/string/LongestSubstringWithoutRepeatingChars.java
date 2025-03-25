package edu.algo.string;

import java.util.Arrays;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * <pre>
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 * </pre>
 */
public class LongestSubstringWithoutRepeatingChars {

  private static final int NO_OF_CHARS = 256;

  public static void main(String[] args) {
    String str = "geeksforgeeks";
    System.out.println("Input string: " + str);
    int len = longestUniqueSubstring(str);
    System.out.println("Length of the longest non-repeating character: " + len);
  }

  /**
   * Length of the longest substring without repeating characters using Sliding Window.
   *
   * <p>Time Complexity: O(n)
   *
   * @param str - string
   * @return longest length
   */
  private static int longestUniqueSubstring(String str) {
    // if string length is 0
    if (str.isEmpty()) return 0;

    // if string length 1
    if (str.length() == 1) return 1;

    // if string length is more than 2
    int maxLength = 0;
    boolean[] visited = new boolean[NO_OF_CHARS];

    // left and right pointer of sliding window
    int left = 0, right = 0;

    // abcadbcbb -> 4
    // abcbdbcbb -> 3
    while (right < str.length()) {
      // if character is visited
      if (visited[str.charAt(right)]) {
        // The left pointer moves to the right while
        // marking visited characters as false until
        // the repeating character is no longer part
        // of the current window.
        while (visited[str.charAt(right)]) {
          visited[str.charAt(left)] = false;
          left++;
        }
      }

      visited[str.charAt(right)] = true;

      // The length of the current window (right - left + 1) is calculated
      // and answer is updated accordingly.
      maxLength = Math.max(maxLength, (right - left + 1));
      right++;
    }

    return maxLength;
  }

  /**
   * The approach stores the last indexes of already visited characters. The idea is to traverse the
   * string from left to right, for each character at index j, update the i pointer(starting index
   * of current window) to be the maximum of its current value and last Index of str[j] + 1. This
   * step ensures that i is moved to the appropriate position to exclude any repeating characters
   * within the new window.
   *
   * <p>Time Complexity: O(n)
   *
   * @param str - string
   * @return longest length
   */
  private static int longestUniqueSubstring2(String str) {
    int n = str.length();

    int res = 0; // result

    // last index of all characters is initialized as -1
    int[] lastIndex = new int[NO_OF_CHARS];
    Arrays.fill(lastIndex, -1);

    // Initialize start of current window
    int i = 0;

    // abcadbcbb -> max = 4
    // Move end of current window
    for (int j = 0; j < n; j++) {
      // Find the last index of str[j]
      // Update i (starting index of current window)
      // as maximum of current value of i and last index plus 1
      i = Math.max(i, lastIndex[str.charAt(j)] + 1);

      // Update result if we get a larger window
      res = Math.max(res, j - i + 1);

      // Update last index of j.
      lastIndex[str.charAt(j)] = j;
    }

    return res;
  }

  private static int longestUniqueSubstring3(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }

    if (s.length() == 1) {
      return 1;
    }

    int left = 0;

    int max = 1;
    for (int right = 1; right < s.length(); right++) {
      int k = left;
      int count = 0;
      while (k < right) {
        count++;
        if (s.charAt(k) == s.charAt(right)) {
          left += count;
          break;
        }
        k++;
      }

      max = Math.max(max, right - left + 1);
    }

    return max;
  }

  /**
   * Time complexity: O(n^2)
   */
  private static int longestUniqueSubstring4(String str) {
    int length = str.length();

    if (length == 0) {
      return 0;
    }

    if (length == 1) {
      return 1;
    }

    int maxLength = 0;

    for (int i = 0; i < str.length(); i++) {
      boolean[] visited = new boolean[256];

      for (int j = i; j < length; j++) {
        if (visited[str.charAt(j)]) {
          break;
        }

        visited[str.charAt(j)] = true;
        maxLength = j - i + 1 > maxLength ? j - i + 1 : maxLength;
      }
    }

    return maxLength;
  }
}
