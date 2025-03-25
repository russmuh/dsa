package edu.algo;

public class AddMultiply {

  public static void main(String[] args) {
    System.out.println(add(2, 3)); // 5
    System.out.println(add(5, 1)); // 6
    System.out.println(add(0, 2)); // 2
    System.out.println(add(2, 0)); // 2
    System.out.println(multiply(10, 5)); // 50
    System.out.println(multiply(3, 2)); // 6
    System.out.println(multiply(0, 2)); // 0
    System.out.println(multiply(2, 0)); // 0
  }

  /**
   * Add without basic arithmetic operations.
   *
   * <pre>
   * Return sum a+b without using "+", "-", Math() functions, other math operators, etc...
   *
   * Allowed: increment by 1: var1++
   * Not allowed: a + b
   * Not allowed: a += b
   * </pre>
   */
  public static int add(int a, int b) {
    if (b > 0) {
      while (b-- > 0) {
        a++;
      }
    } else {
      while (b++ < 0) {
        a--;
      }
    }

    return a;
  }

  /**
   * Multiply using recursion. Note that both a and b is positive integers.
   *
   * <pre>
   * Return product a*b without using *, +, Math() functions, other math operators, etc...
   * Use the add() method created above
   * </pre>
   */
  public static int multiply1(int a, int b) {
    if (b == 0) {
      return 0;
    }

    b--;
    return add(a, multiply1(a, b));
  }

  /**
   * Multiply using addition. Note that both a and b is positive integers.
   *
   * <pre>
   * Return product a*b without using *, +, Math() functions, other math operators, etc...
   * Use the add() method created above
   * </pre>
   */
  public static int multiply2(int a, int b) {
    int result = 0;
    for (int i = 0; i < b; i++) {
      result += a;
    }

    return result;
  }

  /**
   * Multiply using add() method. Note that both a and b is positive integers.
   *
   * <pre>
   * Return product a*b without using *, +, Math() functions, other math operators, etc...
   * Use the add() method created above
   * </pre>
   */
  public static int multiply(int a, int b) {
    int result = 0;
    for (int i = 0; i < b; i++) {
      result = add(result, a);
    }

    return result;
  }
}
