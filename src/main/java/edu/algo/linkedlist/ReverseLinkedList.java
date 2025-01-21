package edu.algo.linkedlist;

/**
 * 206. Reverse Linked List
 *
 * <pre>
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Example 2:
 * Input: head = [1,2]
 * Output: [2,1]
 *
 * Example 3:
 * Input: head = []
 * Output: []
 *
 * Constraints:
 *
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 *
 *
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 * </pre>
 */
public class ReverseLinkedList {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  // null, 1, 2, 3, null -> null, 3, 2, 1, null
  public ListNode reverseList(ListNode head) {
    // Initialize three pointers: curr, prev and next
    ListNode current = head, prev = null, next;

    // Traverse all the nodes of Linked List
    while (current != null) {
      // Store next
      next = current.next;

      // Reverse current node's next pointer
      current.next = prev;

      // Move pointers one position ahead
      prev = current;
      current = next;
    }

    // Return the head of reversed linked list
    return prev;
  }

  public ListNode reverseListRecursion(ListNode head) {
    // Base case:
    // If the linked list is empty or has only one node,
    // return the head as it is already reversed.
    if (head == null || head.next == null) {
      return head;
    }

    // Recursive step:
    // Reverse the linked list starting
    // from the second node (head.next).
    ListNode newHead = reverseListRecursion(head.next);

    // Save a reference to the node following
    // the current 'head' node.
    ListNode front = head.next;

    // Make the 'front' node point to the current
    // 'head' node in the reversed order.
    front.next = head;

    // Break the link from the current 'head' node
    // to the 'front' node to avoid cycles.
    head.next = null;

    // Return the 'newHead,' which is the new
    // head of the reversed linked list.
    return newHead;
  }
}
