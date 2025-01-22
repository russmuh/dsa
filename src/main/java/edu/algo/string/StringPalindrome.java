package edu.algo.string;

/**
 * Palindrome String.
 *
 * <pre>
 * A string is called a palindrome if the reverse of the string is the same as the original one.
 *
 * Example: “madam”, “racecar”, “12321”.
 *
 * Given a string s, the task is to check if it is palindrome or not.
 *
 * Example:
 *
 * Input: s = “abba”
 * Output: true
 * Explanation: s is a palindrome
 *
 *
 * Input: s = “abc”
 * Output: false
 * Explanation: s is not a palindrome
 * </pre>
 */
public class StringPalindrome {

  public static void main(final String[] args) {
    String string = "noon";

    System.out.println(isPalindrome(string));
  }

  // Function to check if a string is a palindrome
  public static boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    // Continue looping while the two pointers
    // have not crossed
    while (left < right) {

      // If the characters at the current positions
      // are not equal
      if (s.charAt(left) != s.charAt(right))
        return false;

      // Move the left pointer to the right and
      // the right pointer to the left
      left++;
      right--;
    }

    // If no mismatch is found, return 1 (palindrome)
    return true;
  }

  // radar
  public static boolean isPalindrome2(String string) {
    int end = string.length() - 1;
    for (int start = 0; start < string.length(); start++) {
      if (start == end) {
        break;
      }

      if (string.charAt(start) != string.charAt(end)) {
        return false;
      }

      end--;
    }

    return true;
  }
}
