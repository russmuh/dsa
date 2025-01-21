package edu.algo.string;

/**
 * Maximum consecutive repeating character in string.
 *
 * <pre>
 *
 * Given a string, the task is to find the maximum consecutive repeating character in a string.
 * Note: We do not need to consider the overall count, but the count of repeating that appears in one place.
 *
 * Examples:
 *
 * Input : str = "geeekk"
 * Output : e
 * Input : str = "aaaabbcbbb"
 * Output : a
 *
 * </pre>
 */
public class MaximumConsecutiveRepeatingCharacter {

  public static void main(final String[] args) {
    System.out.println(maximumConsecutiveChar1("aaaabbbbbcbbb"));
  }

  /**
   * Linear time complexity
   *
   * <pre>
   *   Time Complexity : O(n)
   *   Space Complexity : O(1)
   * </pre>
   *
   * @param str - string
   * @return max consecutive char
   */
  public static String maximumConsecutiveChar1(final String str) {
    if (str == null || str.isEmpty()) {
      return "";
    }

    if (str.length() == 1) {
      return str;
    }

    char maxChar = str.charAt(0);
    int maxOccurrences = 0;
    int occurrences = 1;

    final int n = str.length();

    // geeekk
    // aaaabbbbbcbbb
    for (int i = 0; i < n; i++) {
      if (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
        occurrences++;
      } else {
        if (occurrences > maxOccurrences) {
          maxChar = str.charAt(i);
          maxOccurrences = occurrences;
        }

        occurrences = 1;
      }
    }

    return String.valueOf(maxChar);
  }

  /**
   * Quadratic time complexity
   *
   * <pre>
   *   Time Complexity : O(n^2)
   *   Space Complexity : O(1)
   * </pre>
   *
   * @param str - string
   * @return max consecutive char
   */
  public static String maximumConsecutiveChar2(final String str) {
    if (str == null || str.isEmpty()) {
      return "";
    }

    if (str.length() == 1) {
      return str;
    }

    char maxChar = str.charAt(0);
    int occurrences = 1;

    // geeekk
    for (int i = 0; i < str.length(); i++) {
      int counter = 1;

      for (int j = i + 1; j < str.length(); j++) {
        if (str.charAt(i) == str.charAt(j)) {
          counter++;
        } else {
          break;
        }
      }

      if (counter > occurrences) {
        maxChar = str.charAt(i);
        occurrences = counter;
      }
    }

    return String.valueOf(maxChar);
  }
}
