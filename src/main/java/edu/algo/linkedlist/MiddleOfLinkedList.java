package edu.algo.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 876. Middle of the Linked List
 *
 * <pre>
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 *
 * Example 2:
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 100].
 * 1 <= Node.val <= 100
 * </pre>
 */
public class MiddleOfLinkedList {
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

  public ListNode middleNode(ListNode head) {
    Map<Integer, ListNode> map = new HashMap<>();

    int counter = 1;
    ListNode current = head;
    while (current != null) {
      map.put(counter++, current);
      current = current.next;
    }

    int middle = counter % 2 == 0 ? counter / 2 : counter / 2 + 1;
    return map.get(middle);
  }
}
