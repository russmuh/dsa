package edu.algo.string;

import java.util.Scanner;

/**
 * How to reverse a String in java? Can you write a program without using any java built-in methods?
 */
public class ReverseString {

  public static void main(final String[] args) {
    System.out.print("Type a string: ");
    final Scanner in = new Scanner(System.in);

    final String string = in.nextLine();
    System.out.printf("\nReversed: %s", reverse(string));
    System.out.printf("\nReversed: %s", reverseViaForLoop(string));

    final char[] reverse = new char[string.length()];
    reverseViaRecursion(string, reverse, string.length());
    System.out.printf("\nReversed: %s", new String(reverse));

    System.out.printf("\nReversed: %s", reverseViaRecursion2(string));
  }

  private static String reverse(final String string) {
    final StringBuilder reverse = new StringBuilder();

    for (int i = string.length() - 1; i >= 0; i--) {
      reverse.append(string.charAt(i));
    }

    return reverse.toString();
  }

  private static String reverseViaForLoop(final String string) {
    final char[] reversedString = new char[string.length()];

    for (int i = 0; i < string.length(); i++) {
      reversedString[i] = string.charAt(string.length() - (i + 1));
    }

    return new String(reversedString);
  }

  private static void reverseViaRecursion(final String string, final char[] reverse, final int index) {
    if (index > 0) {
      reverse[index - 1] = string.charAt(string.length() - index);
      reverseViaRecursion(string, reverse, index - 1);
    }
  }

  public static String reverseViaRecursion2(final String string) {
    if (string.length() == 1) {
      return string;
    } else {
      return string.charAt(string.length() - 1)
          + reverseViaRecursion2(string.substring(0, string.length() - 1));
      }
  }
}
