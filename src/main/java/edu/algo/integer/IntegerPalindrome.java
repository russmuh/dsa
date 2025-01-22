package edu.algo.integer;

/**
 * Palindrome Integer.
 *
 * <pre>
 * An integer is called a palindrome if the reverse of the integer is the same as the original one.
 *
 * Example: 12321, 1001, 543212345
 *
 * Given an integer n, the task is to check if it is palindrome or not.
 *
 * Example:
 *
 * Input: n = 12321
 * Output: true
 * Explanation: n is a palindrome
 *
 *
 * Input: n = 12345
 * Output: false
 * Explanation: n is not a palindrome
 * </pre>
 */
public class IntegerPalindrome {

    public static void main(final String[] args) {
        System.out.println(isPalindrome(1234543210));
    }

    public static boolean isPalindrome(int n) {
        int reverse = 0;
        int temp = n;

        while (temp != 0) {
            reverse = reverse * 10 + temp % 10;
            temp /= 10;
        }

        return n == reverse;
    }
}
