package datastructures.linkedlist;

import java.util.HashMap;

public class LinkedList<T> {
  public Node<T> head = null;
  private int size = 0;

  // Code Challenge 05
  public void insert(T value) {
    Node<T> newHeadNode = new Node<>(value);
    newHeadNode.next = head;
    head = newHeadNode;
    size++;
  }

  public boolean includes(T value) {
    Node<T> current = head;
    while(current != null) {
      if(current.value.equals(value))
        return true;
      current = current.next;
    }
    return false;
  }
  @Override
  public String toString() {
    String output = "";
    Node<T> current = head;
    while(current != null) {
     output += "{ " + current.value + " } -> ";
     current = current.next;
    }
    return output + "NULL";
  }

  // Code Challenge 06

  public void append(T value) {
    Node<T> newTailNode = new Node<>(value);
    if(head == null) {
      newTailNode.next = null;
      head = newTailNode;
    } else {
      Node<T> current = head;
      while(current.next != null) {
        current = current.next;
      }
      current.next = newTailNode;
      newTailNode.next = null;
    }
    size++;
  }

  public void insertBefore(T value, T newValue) {
    if (head == null) {
      throw new IllegalArgumentException(value + " not found in list");
    }
    if(head.value == value) {
      insert(newValue);
      return;
    }
    Node<T> current = head;
    Node<T> insertNode = new Node<>(newValue);
    while(current.next != null) {
      if(current.next.value.equals(value)) {
        insertNode.next = current.next;
        current.next = insertNode;
        size++;
        break;
      } else
      current = current.next;
    }
    if(current.next == null)
      throw new IllegalArgumentException(value + " not found in list");
  }

  public void insertAfter(T value, T newValue) {
    if (head == null) {
      throw new IllegalArgumentException(value + " not found in list");
    }
    Node<T> current = head;
    Node<T> insertNode = new Node<>(newValue);
    while(current != null) {
      if(current.value.equals(value)) {
        insertNode.next = current.next;
        current.next = insertNode;
        size++;
        break;
      }
      current = current.next;
    }
    if(current == null)
      throw new IllegalArgumentException(value + " not found in list");
  }

  public void delete(T value) {
    if (head == null) {
      throw new IllegalArgumentException(value + " not found in list");
    }
    if (head.value.equals(value)) {
      head = head.next;
      size--;
      return;
    }
    Node<T> current = head;
    while(current.next != null) {
      if(current.next.value.equals(value)) {
        current.next = (current.next.next);
        size--;
        return;
      }
      current = current.next;
    }
    if(current.value.equals(value))
      current = null;
    else
      throw new IllegalArgumentException(value + " not found in list");
  }

public T kthFromEnd(int k) {
  if(head == null || k < 0)
    throw new IllegalArgumentException("position " + k + " out of bounds");
  HashMap<Integer, T> valueMap = new HashMap<>();
  Node<T> current;
  current = head;
  int position = 0;
  while(current != null) {
    valueMap.put(position++, current.value);
    current = current.next;
  }
  if(k >= valueMap.size())
    throw new IllegalArgumentException("position " + k + " out of bounds");
  return valueMap.get((valueMap.size() - 1) - k);
  }

  public T kthFromEndWithSize(int k) {
    int targetPosition = (size - 1) - k;
    if(k < 0 || targetPosition < 0 || targetPosition > size)
      throw new IllegalArgumentException("position " + k + " out of bounds");
    Node<T> current;
    current = head;
    int position = 0;
    while(current != null) {
      if(position == targetPosition) {
        return current.value;
      }
      position++;
      current = current.next;
    }
    throw new IllegalArgumentException("position " + k + " out of bounds");
  }

  public int size() {
    return size;
  }
}
