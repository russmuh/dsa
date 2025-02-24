package edu.algo;

import java.util.HashMap;
import java.util.Map;

public class Cache<K, V> {

  private static final int EXPIRE_MILLIS = 5 * 60 * 1000;

  public static class Node<V> {

    private long timestamp;
    private V value;

    public Node(final V value) {
      this.timestamp = System.currentTimeMillis();
      this.value = value;
    }
  }

  private final Map<K, Node<V>> cache;

  public Cache() {
    cache = new HashMap<>();
  }

  public V get(final K key) {
    final Node<V> node = cache.get(key);
    if (node.timestamp > System.currentTimeMillis() + EXPIRE_MILLIS) {
      cache.remove(key);
      return null;
    }

    return node.value;
  }

  public void put(final K key, final V value) {
    cache.put(key, new Node<>(value));
  }
}
