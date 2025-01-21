package edu.algo;

public class CustomMap<K, V> {

  static class Node<K, V> {
    private K key;
    private V value;
    private Node<K, V> next;

    public K getKey() {
      return key;
    }

    public V getValue() {
      return value;
    }
  }

  private int capacity = 16;
  private int size;

  private Node<K, V>[] table;

  public CustomMap() {
    table = new Node[capacity];

    for (int i = 0; i < capacity; i++) {
      table[i] = new Node<>();
    }
  }

  public V get(final K key) {
    final int index = getIndex(key);
    return table[index].value;
  }

  public int getIndex(final K key) {
    return key.hashCode() % capacity;
  }

  public void put(final K key, final V value) {
    final int index = getIndex(key);

    final Node node = table[index];
    if (node.key == null) {
      node.key = key;
      node.value = value;
    } else if (node.key.equals(key)) {
      node.value = value;
    } else {
      node.next = new Node<>();
      node.next.key = key;
      node.next.value = value;
    }

    size++;
  }

  public void remove(final K key) {
    final int index = getIndex(key);
    final Node<K, V> node = table[index];

    Node<K, V> current = node;
    while (current != null) {
      if (current.key.equals(key)) {
        current.key = null;
        current.value = null;

        table[index] = current.next;
        break;
      }
      current = current.next;
    }
  }
}
