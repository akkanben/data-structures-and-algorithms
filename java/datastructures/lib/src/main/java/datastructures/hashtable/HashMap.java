package datastructures.hashtable;

import datastructures.linkedlist.LinkedList;
import datastructures.linkedlist.Node;

import java.util.ArrayList;
import java.util.List;

// NOTE: Does NOT preserve insertion order!
// WARNING: Don't make K an Object or Character!
public class HashMap<K, V> {
  ArrayList<LinkedList<HashMapPair<K, V>>> bucketArrayList;  // using ArrayList instead of array so we can instantiate with a parameterized type
  int size;

  public HashMap() {
    size = 10;
    this.bucketArrayList = new ArrayList<>(size);
    for (int i = 0; i < this.size; i++) {
      bucketArrayList.add(i, new LinkedList<HashMapPair<K, V>>());
    }
  }

  public HashMap(int size) {
    if (size < 1) {
      throw new IllegalArgumentException("HashMap size must be 1 or greater!");
    }

    this.size = size;
    this.bucketArrayList = new ArrayList<>(size);

    for (int i = 0; i < this.size; i++) {
      bucketArrayList.add(i, new LinkedList<HashMapPair<K, V>>());
    }
  }

  public void set(K key, V value) {
    int index = hash(key);
    HashMapPair<K, V> newPair = new HashMapPair<>(key, value);
    if (bucketArrayList.get(index) != null) {
      LinkedList<HashMapPair<K, V>> list = bucketArrayList.get(index);
      Node<HashMapPair<K, V>> current;
      current = list.head;
      while (current != null && current.value.getKey() != key) {
        current = current.next;
      }
      if (current != null && current.value.getValue() != value) {
        current.value.setValue(value);
        return;
      }
    }
    LinkedList<HashMapPair<K, V>> list = bucketArrayList.get(index);
    list.append(newPair);
    bucketArrayList.set(index, list);
  }

  public V get(K key) {
    int index = hash(key);
    if (bucketArrayList.get(index) != null) {
      LinkedList<HashMapPair<K, V>> list = bucketArrayList.get(index);
      Node<HashMapPair<K, V>> current;
      current = list.head;
      while (current != null && current.value.getKey() != key) {
        current = current.next;
      }
      if (current != null) {
        return current.value.getValue();
      }
    }
    throw new IllegalArgumentException("Key not found.");
  }

  public boolean contains(K key) {
    int index = hash(key);
    if (bucketArrayList.get(index) != null) {
      LinkedList<HashMapPair<K, V>> list = bucketArrayList.get(index);
      Node<HashMapPair<K, V>> current;
      current = list.head;
      while (current != null && current.value.getKey() != key) {
        current = current.next;
      }
      return current != null;
    }
    return false;
  }

  public List<K> keys() {
    List<K> output = new ArrayList<>();
    for (LinkedList<HashMapPair<K, V>> list : bucketArrayList) {
      if (list != null) {
        Node<HashMapPair<K, V>> current;
        current = list.head;
        while (current != null) {
          output.add(current.value.getKey());
          current = current.next;
        }
      }
    }
    return output;
  }

  public int hash(K key) {
    return Math.abs(key.hashCode()) % size;
  }
}
