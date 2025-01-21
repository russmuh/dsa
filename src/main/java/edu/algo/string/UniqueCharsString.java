package edu.algo.string;

import java.util.Scanner;

/**
 * Write a program to check if String has all unique characters
 */
public class UniqueCharsString {

  public static void main(final String[] args) {
    System.out.print("Provide a string: ");
    final Scanner scanner = new Scanner(System.in);
    final String string = scanner.nextLine();

    System.out.println("This string has unique characters: " + containsUniqueChars(string));
  }

  private static boolean containsUniqueChars(final String string) {
    for (int i = 0; i < string.length(); i++) {
      for (int j = i + 1; j < string.length(); j++) {
        if (string.charAt(i) == string.charAt(j)) {
          return false;
        }
      }
    }

    return true;
  }
}
