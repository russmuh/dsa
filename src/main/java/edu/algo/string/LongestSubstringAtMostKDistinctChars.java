package edu.algo.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 340. Longest Substring with At Most K Distinct Characters
 *
 * <pre>
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 *
 * Example 1:
 *
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: T is "ece" which its length is 3.
 * Example 2:
 *
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: T is "aa" which its length is 2.
 * </pre>
 */
public class LongestSubstringAtMostKDistinctChars {

  public static void main(final String[] args) {
    System.out.println(findSubstring(2, "eceba")); // 3
    System.out.println(findSubstring(1, "ccaabbb")); // 3
  }

  public static int findSubstring(final int k, final String str) {
    // Create a HashMap to store the frequency of each character.
    final Map<Character, Integer> charFrequencyMap = new HashMap<>();
    int length = str.length();
    int maxLength = 0; // This will hold the length of the longest substring with at most two distinct characters.

    int left = 0, right = 0;
    // Two pointers defining the window of characters under consideration
    while (right < length) {
      // Get the current character from the string.
      char currentChar = str.charAt(right);
      // Increase the frequency count of the character in our map.
      charFrequencyMap.put(currentChar, charFrequencyMap.getOrDefault(currentChar, 0) + 1);

      // If the map contains more than two distinct characters, shrink the window from the left
      while (charFrequencyMap.size() > k) {
        char leftChar = str.charAt(left);
        // Decrease the frequency count of this character.
        charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
        // Remove the character from the map if its count drops to zero, to maintain at most two distinct characters.
        if (charFrequencyMap.get(leftChar) == 0) {
          charFrequencyMap.remove(leftChar);
        }
        // Move the left pointer to the right
        left++;
      }

      // Calculate the maximum length encountered so far.
      maxLength = Math.max(maxLength, right - left + 1);
      right++;
    }

    // Return the maximum length found.
    return maxLength;
  }
}
