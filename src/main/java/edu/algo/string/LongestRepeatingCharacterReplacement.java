package edu.algo.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 424. Longest Repeating Character Replacement LEVEL: MEDIUM
 *
 * <pre>
 * You are given a string s and an integer k. You can choose any character of the string and
 * change it to any other uppercase English character. You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can get after
 * performing the above operations.
 *
 *
 * Example 1:
 *
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * Example 2:
 *
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * There may exists other ways to achieve this answer too.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only uppercase English letters.
 * 0 <= k <= s.length
 * </pre>
 *
 * <pre>
 * Steps to solve:
 * 1. Initialize Variables: Use variables to keep track of the window’s start and end,
 *    the count of the most frequent character in the current window, and a frequency
 *    map for the characters in the window.
 * 2. Expand the Window: Increase the window size by moving the end pointer and
 *    update the frequency map.
 * 3. Check Validity: If the current window size minus the count of the most frequent
 *    character is greater than k, the window is invalid. In this case, move the start
 *    pointer to shrink the window until it becomes valid.
 * 4. Update Result: Keep track of the maximum window size encountered.
 * </pre>
 */
public class LongestRepeatingCharacterReplacement {

  public static void main(final String[] args) {
    System.out.println(characterReplacement("BAAAB", 2));
  }

  public static int characterReplacement(final String str, int k) {
    int left = 0;

    Map<Character, Integer> charCount = new HashMap<>();

    int maxLength = 0, maxCount = 0;
    // AABABBA -> 1
    for (int right = 0; right < str.length(); right++) {
      char rightChar = str.charAt(right);
      charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);

      maxCount = Math.max(maxCount, charCount.get(rightChar));
      int windowSize = right - left + 1;
      if (windowSize - maxCount > k) {
        char leftChar = str.charAt(left);
        charCount.put(leftChar, charCount.get(leftChar) - 1);
        left++;
      }

      maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
  }

  public static int characterReplacement2(String s, int k) {
    int[] letterCount = new int[26]; // Array to store the frequency count of each letter
    int windowStart = 0; // Start index of the sliding window
    int windowEnd = 0; // End index of the sliding window
    int maxCountInWindow = 0; // Variable to store the maximum count of a single character in the current window

    // Iterate over the string with windowEnd serving as the end pointer of the sliding window
    for (; windowEnd < s.length(); ++windowEnd) {
      char currentChar = s.charAt(windowEnd); // Current character in iteration
      letterCount[currentChar - 'A']++; // Increment the count for this character in the frequency array

      // Update the maxCountInWindow to be the max between itself and the count of the current character
      maxCountInWindow = Math.max(maxCountInWindow, letterCount[currentChar - 'A']);

      // Check if current window size minus max frequency count is greater than k
      // If it is, we need to slide the window ahead while decrementing the count of the char at windowStart
      if (windowEnd - windowStart + 1 - maxCountInWindow > k) {
        letterCount[s.charAt(windowStart) - 'A']--; // Decrement count of the start character of the window
        windowStart++; // Move the window's start index forward
      }
    }
    // The maximum length substring is the size of the window on loop exit
    return windowEnd - windowStart;
  }
}
