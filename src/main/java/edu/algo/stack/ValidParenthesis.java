package edu.algo.stack;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 *
 * <pre>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 * Example 1:
 *
 * Input: s = "()"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "()[]{}"
 *
 * Output: true
 *
 * Example 3:
 *
 * Input: s = "(]"
 *
 * Output: false
 *
 * Example 4:
 *
 * Input: s = "([])"
 *
 * Output: true
 * </pre>
 */
public class ValidParenthesis {

  public static void main(String[] args) {
    System.out.println(isValid("[{(})]"));
  }

  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char currentChar = s.charAt(i);
      if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
        stack.push(currentChar);
      } else if (!stack.isEmpty()
          && ((stack.peek() == '(' && currentChar == ')')
              || (stack.peek() == '{' && currentChar == '}')
              || (stack.peek() == '[' && currentChar == ']'))) {
        stack.pop();
      } else {
        return false;
      }
    }

    return stack.isEmpty();
  }
}
