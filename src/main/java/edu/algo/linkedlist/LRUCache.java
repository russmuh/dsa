package edu.algo.linkedlist;

import java.util.HashMap;
import java.util.Map;

/** */
public class LRUCache {

  class Node {

    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private int capacity;
  private Map<Integer, Node> cache;
  private Node head;
  private Node tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;

    cache = new HashMap<>();

    head = new Node(0, 0);
    tail = new Node(0, 0);

    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    Node node = cache.get(key);

    if (node == null) {
      return -1;
    }

    remove(node);
    addToHead(node);

    return node.value;
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      remove(cache.get(key));
    }

    if (cache.size() == capacity) {
      remove(tail.prev);
    }

    addToHead(new Node(key, value));
  }

  private void addToHead(Node node) {
    cache.put(node.key, node);

    node.next = head.next;
    node.next.prev = node;
    node.prev = head;
    head.next = node;
  }

  private void remove(Node node) {
    cache.remove(node.key);

    node.prev.next = node.next;
    node.next.prev = node.prev;
  }
}
