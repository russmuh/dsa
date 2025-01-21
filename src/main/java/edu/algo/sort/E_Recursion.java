package edu.algo.sort;

/**
 * Calculate Fibonacci numbers
 */
public class E_Recursion {

  public static void main(final String[] args) {
    System.out.println(fib(10));
  }

  private static int fib(final int number) {
    if (number <= 1) {
      return number;
    }

    return fib(number - 1) + fib(number - 2);
  }
}
