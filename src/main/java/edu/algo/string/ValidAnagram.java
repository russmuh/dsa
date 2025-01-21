package edu.algo.string;

/**
 * 242. Valid Anagram
 *
 * <pre>
 * Given two strings s and t, return true if t is an
 * anagram of s, and false otherwise.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 * </pre>
 */
public class ValidAnagram {

  public static void main(String[] args) {
    System.out.println(isAnagram1("anagram", "nagaram"));
    System.out.println(isAnagram1("rat", "car"));
  }

  public static boolean isAnagram1(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    if (s.isEmpty()) {
      return false;
    }

    int[] buffer = new int[256];

    // anagram -> nagaram
    for (int i = 0; i < s.length(); i++) {
      buffer[s.charAt(i)]++;
    }

    for (int i = 0; i < t.length(); i++) {
      if (buffer[t.charAt(i)] > 0) {
        buffer[t.charAt(i)]--;
      }
    }

    for (final int j : buffer) {
      if (j > 0) {
        return false;
      }
    }

    return true;
  }

  public static boolean isAnagram2(String s, String t) {
    // If lengths are different, they cannot be anagrams
    if (s.length() != t.length()) {
      return false;
    }

    // Create arrays to count frequency of each character (assuming lowercase English letters)
    int[] count = new int[26];

    // Count frequency of characters in string s1
    for (char c : s.toCharArray()) {
      count[c - 'a']++;
    }

    // Subtract frequency of characters in string s2
    for (char c : t.toCharArray()) {
      count[c - 'a']--;
    }

    // Check if all counts are zero
    for (int i = 0; i < 26; i++) {
      if (count[i] != 0) {
        return false;
      }
    }

    return true;
  }

  // This approach has time complexity of O(n), but it requires extra space for count Array.
  public static boolean isAnagram3(final String str1, final String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }

    int[] count = new int[256];
    for (int i = 0; i < str1.length(); i++) {
      count[str1.charAt(i)]++;
      count[str2.charAt(i)]--;
    }

    for (int i = 0; i < 256; i++) {
      if (count[i] != 0) {
        return false;
      }
    }

    return true;
  }

  private static char[] sort(final char[] chars) {
    char temp;

    for (int i = 0; i < chars.length; i++) {
      for (int j = i + 1; j < chars.length; j++) {
        if (chars[i] > chars[j]) {
          temp = chars[i];
          chars[i] = chars[j];
          chars[j] = temp;
        }
      }
    }

    return chars;
  }
}
