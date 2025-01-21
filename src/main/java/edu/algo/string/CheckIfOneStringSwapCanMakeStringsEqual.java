package edu.algo.string;

/**
 * 1790. Check if One String Swap Can Make Strings Equal
 *
 * <pre>
 * You are given two strings s1 and s2 of equal length. A string swap is an operation where
 * you choose two indices in a string (not necessarily different) and swap the characters at these indices.
 *
 * Return true if it is possible to make both strings equal by performing at most one string
 * swap on exactly one of the strings. Otherwise, return false.
 *
 *
 * Example 1:
 *
 * Input: s1 = "bank", s2 = "kanb"
 * Output: true
 * Explanation: For example, swap the first character with the last character of s2 to make "bank".
 *
 * Example 2:
 *
 * Input: s1 = "attack", s2 = "defend"
 * Output: false
 * Explanation: It is impossible to make them equal with one string swap.
 *
 * Example 3:
 *
 * Input: s1 = "kelb", s2 = "kelb"
 * Output: true
 * Explanation: The two strings are already equal, so no string swap operation is required.
 *
 *
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 100
 * s1.length == s2.length
 * s1 and s2 consist of only lowercase English letters.
 * </pre>
 */
public class CheckIfOneStringSwapCanMakeStringsEqual {

  public boolean areAlmostEqual(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return false;
    }

    if (s1.length() != s2.length()) {
      return false;
    }

    char mismatchCount = 0;
    char mismatchS1 = 0;
    char mismatchS2 = 0;

    boolean hasSameChar;

    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        mismatchCount++;

        if (mismatchCount == 1) {
          mismatchS1 = s1.charAt(i);
          mismatchS2 = s2.charAt(i);
        } else if (mismatchCount == 2) {
          hasSameChar = mismatchS1 == s2.charAt(i) && mismatchS2 == s1.charAt(i);

          if (!hasSameChar) return false;
        }

        if (mismatchCount > 2) {
          return false;
        }
      }
    }

    return mismatchCount != 1;
  }
}
