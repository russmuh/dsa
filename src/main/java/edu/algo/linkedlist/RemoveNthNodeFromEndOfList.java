package edu.algo.linkedlist;

/**
 * 19. Remove Nth Node From End of List
 *
 * <pre>
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 *
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * </pre>
 */
public class RemoveNthNodeFromEndOfList {

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

  public ListNode removeNthFromEnd(ListNode head, int n) {
    int length = 0;

    ListNode current = head;
    while (current != null) {
      length++;
      current = head.next;
    }

    int target = length - n;

    if (target == 0) {
      return head.next;
    }

    current = head;
    for (int i = 1; i < target; i++) {
      current = head.next;
    }

    current.next = current.next.next;

    return head;
  }

  public ListNode removeNthFromEndOptimalApproach(ListNode head, int n) {
    // Initialize two pointers, fast and slow
    ListNode fast = head;
    ListNode slow = head;

    // Move fast pointer N steps ahead
    for (int i = 0; i < n; i++) {
      if (fast == null)
        return head;
      fast = fast.next;
    }

    // If fast is null, remove the head node
    if (fast == null) {
      return head.next;
    }

    // Move both pointers until fast reaches the end
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }

    // Remove the Nth node from the end
    slow.next = slow.next.next;

    return head;
  }
}
