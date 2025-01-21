package edu.algo.string;

import java.util.*;

/**
 * 159. Longest Substring with At Most Two Distinct Characters
 *
 * <pre>
 * Given a string s , find the length of the longest substring t that contains at most 2 distinct characters.
 *
 * Example 1:
 *
 * Input: "eceba"
 * Output: 3
 * Explanation: t is "ece" which its length is 3.
 *
 * Example 2:
 *
 * Input: "ccaabbb"
 * Output: 5
 * Explanation: t is "aabbb" which its length is 5.
 * </pre>
 */
public class LongestSubstringAtMostTwoDistinctChars {

  public static void main(final String[] args) {
    System.out.println(findSubstring("eceba")); // 3
    System.out.println(findSubstring("ccaabbb")); // 5
  }

  public static int findSubstring(final String str) {
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
      while (charFrequencyMap.size() > 2) {
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
