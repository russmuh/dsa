package edu.algo.stack;

import java.util.Stack;

/**
 * 155. Min Stack
 *
 * <pre>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 *
 * You must implement a solution with O(1) time complexity for each function.
 *
 *
 * Example 1:
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 *
 * Constraints:
 *
 * -231 <= val <= 231 - 1
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 * At most 3 * 104 calls will be made to push, pop, top, and getMin.
 * </pre>
 */
public class MinStack {

  // ------------- FIRST APPROACH --------------------

  //  class Node {
  //
  //    private int val, min;
  //    private Node prev;
  //  }
  //
  //  private final Node tail;
  //  private Integer min;
  //
  //  public MinStack() {
  //    tail = new Node();
  //  }
  //
  //  public void push(int val) {
  //    if (min == null) {
  //      min = val;
  //    } else {
  //      min = Math.min(min, val);
  //    }
  //
  //    Node newNode = new Node();
  //    newNode.val = val;
  //    newNode.min = min;
  //    newNode.prev = tail.prev;
  //    tail.prev = newNode;
  //  }
  //
  //  public void pop() {
  //    if (tail.prev != null) {
  //      tail.prev = tail.prev.prev;
  //
  //      if (tail.prev != null) {
  //        min = tail.prev.min;
  //      } else {
  //        min = null;
  //      }
  //    }
  //  }
  //
  //  public int top() {
  //    return tail.prev.val;
  //  }
  //
  //  public int getMin() {
  //    return tail.prev.min;
  //  }

  // --------------------- SECOND APPROACH ------------------

  class Node {
    int val, min;

    Node(int val, int min) {
      this.val = val;
      this.min = min;
    }
  }

  private final Stack<Node> stack;

  public MinStack() {
    stack = new Stack<>();
  }

  public void push(int val) {
    int min;
    if (stack.isEmpty()) {
      min = val;
    } else {
      min = Math.min(stack.peek().min, val);
    }
    stack.push(new Node(val, min));
  }

  public void pop() {
    stack.pop();
  }

  public int top() {
    return stack.peek().val;
  }

  public int getMin() {
    return stack.peek().min;
  }
}
