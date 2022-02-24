package datastructures.linkedlist;

import java.util.HashMap;

public class LinkedList<T> {
  Node<T> head = null;

  // Code Challenge 05
  public void insert(T value) {
    Node<T> newHeadNode = new Node<>(value);
    newHeadNode.setNext(head);
    head = newHeadNode;
  }

  public boolean includes(T value) {
    Node<T> current = head;
    while(current != null) {
      if(current.getValue().equals(value))
        return true;
      current = current.getNext();
    }
    return false;
  }
  @Override
  public String toString() {
    String output = "";
    Node<T> current = head;
    while(current != null) {
     output += "{ " + current.getValue() + " } -> ";
     current = current.getNext();
    }
    return output + "NULL";
  }

  // Code Challenge 06

  public void append(T value) {
    Node<T> newTailNode = new Node<>(value);
    if(head == null) {
      newTailNode.setNext(null);
      head = newTailNode;
    } else {
      Node<T> current = head;
      while(current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(newTailNode);
      newTailNode.setNext(null);
    }
  }

  public void insertBefore(T value, T newValue) {
    if (head == null) {
      throw new IllegalArgumentException(value + " not found in list");
    }
    if(head.getValue() == value) {
      insert(newValue);
      return;
    }
    Node<T> current = head;
    Node<T> insertNode = new Node<>(newValue);
    while(current.getNext() != null) {
      if(current.getNext().getValue().equals(value)) {
        insertNode.setNext(current.getNext());
        current.setNext(insertNode);
        break;
      } else
      current = current.getNext();
    }
    if(current.getNext() == null)
      throw new IllegalArgumentException(value + " not found in list");
  }

  public void insertAfter(T value, T newValue) {
    if (head == null) {
      throw new IllegalArgumentException(value + " not found in list");
    }
    Node<T> current = head;
    Node<T> insertNode = new Node<>(newValue);
    while(current != null) {
      if(current.getValue().equals(value)) {
        insertNode.setNext(current.getNext());
        current.setNext(insertNode);
        break;
      }
      current = current.getNext();
    }
    if(current == null)
      throw new IllegalArgumentException(value + " not found in list");
  }

  public void delete(T value) {
    if (head == null) {
      throw new IllegalArgumentException(value + " not found in list");
    }
    if (head.getValue().equals(value)) {
      head = head.getNext();
      return;
    }
    Node<T> current = head;
    while(current.getNext() != null) {
      if(current.getNext().getValue().equals(value)) {
        current.setNext(current.getNext().getNext());
        return;
      }
      current = current.getNext();
    }
    if(current.getValue().equals(value))
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
    valueMap.put(position++, current.getValue());
    current = current.getNext();
  }
  if(k >= valueMap.size())
    throw new IllegalArgumentException("position " + k + " out of bounds");
  return valueMap.get((valueMap.size() - 1) - k);
  }

  public T kthFromEndWithSize(int k, int size) {
    int targetPosition = (size - 1) - k;
    if(k < 0 || targetPosition < 0 || targetPosition > size)
      throw new IllegalArgumentException("position " + k + " out of bounds");
    Node<T> current;
    current = head;
    int position = 0;
    while(current != null) {
      if(position == targetPosition) {
        return current.getValue();
      }
      position++;
      current = current.getNext();
    }
    throw new IllegalArgumentException("position " + k + " out of bounds");
  }
}
