package edu.algo.tree;

import java.util.Stack;

public class PreorderTreeTraversal {
  public static class Node {
    int data;
    Node left;
    Node right;
    public Node(int item) {
      data = item;
      left = null;
      right = null;
    }
  }

  // Function to implement
  static void preorderTraversal(Node node) {
    if (node == null) {
      return;
    }

    Stack<Node> stack = new Stack<>();
    stack.push(node);

    while (!stack.isEmpty()) {
      Node node1 = stack.pop();

      System.out.print(node1.data + " ");

      if (node1.right != null) {
        stack.push(node1.right);
      }

      if (node1.left != null) {
        stack.push(node1.left);
      }
    }
  }

  // 5 4 11 8 13 4
  static Node makeTree1() {// O(N)
        /*
                5
               / \
              4    8
             /    / \
            11   13  4
        */
    Node root = new Node(5);
    root.left = new Node(4);
    root.right = new Node(8);
    root.left.left = new Node(11);
    root.right.left = new Node(13);
    root.right.right = new Node(4);
    return root;
  }
  // 5 4 11 8 4 2 10
  static Node makeTree2() {
        /*
                5
               / \
              4    8
             /      \
            11       4
                    / \
                   2  10
        */
    Node root = new Node(5);
    root.left = new Node(4);
    root.right = new Node(8);
    root.left.left = new Node(11);
    root.right.right = new Node(4);
    root.right.right.left = new Node(2);
    root.right.right.right = new Node(10);
    return root;
  }

  public static void main(String[] args) {
    Node tree1 = makeTree1();
    System.out.println("Actual:");
    preorderTraversal(tree1);
    System.out.println("\nExpected:");
    System.out.println("5 4 11 8 13 4");
    Node tree2 = makeTree2();
    System.out.println("\nActual:");
    preorderTraversal(tree2);
    System.out.println("\nExpected:");
    System.out.println("5 4 11 8 4 2 10");
  }
}
