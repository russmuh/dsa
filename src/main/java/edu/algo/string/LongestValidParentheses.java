package edu.algo.string;

import java.util.Stack;

/**
 *
 *
 * <pre>
 * 32. Longest Valid Parentheses
 *
 * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
 * substring.
 *
 *
 * Example 1:
 *
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 *
 * Example 2:
 *
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 *
 * Example 3:
 *
 * Input: s = ""
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 3 * 104
 * s[i] is '(', or ')'.
 * </pre>
 */
public class LongestValidParentheses {

  public static void main(final String[] args) {
    System.out.println(longestValidParentheses("(()")); // 2
    System.out.println(longestValidParentheses("()(()")); // 2
    System.out.println(longestValidParentheses(")()())")); // 4
    System.out.println(longestValidParentheses("")); // 0
    System.out.println(longestValidParentheses("()(())")); // 6
    System.out.println(longestValidParentheses(")(")); // 0
    System.out.println(longestValidParentheses(")((()(()))()()))()())((())(())()()(")); // 26
  }

  public static int longestValidParentheses(String s) {
    Stack<Integer> stk = new Stack<>();
    if (!s.isEmpty()) stk.push(0);
    for (int i = 1; i < s.length(); i++) {
      if (stk.isEmpty()) stk.push(i);
      else if (s.charAt(stk.peek()) == '(' && s.charAt(i) == ')') {

        stk.pop();
      } else stk.push(i);
    }

    if (stk.isEmpty()) return s.length();

    if (stk.size() == 1 && s.length() != 1 && ((stk.peek() == 0) || (stk.peek() == s.length() - 1)))
      return s.length() - 1;

    int max = 0;
    int len = s.length() - 1;
    while (!stk.isEmpty()) {
      int a = stk.pop();
      max = Math.max(len - a, max);
      len = a - 1;
    }

    return Math.max(max, len - 0 + 1);
  }
}
