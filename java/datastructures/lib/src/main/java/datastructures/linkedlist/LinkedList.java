package datastructures.linkedlist;

public class LinkedList {
  Node head = null;

  // Code Challenge 05
  public void insert(int value) {
    Node newHeadNode = new Node(value);
    newHeadNode.setNext(head);
    head = newHeadNode;
  }

  public boolean includes(int value) {
    Node current = head;
    while(current != null) {
      if(current.getValue() == value)
        return true;
      current = current.getNext();
    }
    return false;
  }
  @Override
  public String toString() {
    String output = "";
    Node current = head;
    while(current != null) {
     output += "{ " + current.getValue() + " } -> ";
     current = current.getNext();
    }
    return output + "NULL";
  }

  // Code Challenge 06

  public void append(int value) {
    Node newTailNode = new Node(value);
    if(head == null) {
      newTailNode.setNext(head);
      head = newTailNode;
    } else {
      Node current = head;
      while(current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(newTailNode);
      newTailNode.setNext(null);
    }
  }

  public void insertBefore(int value, int newValue) {
    if (head == null) {
      throw new IllegalArgumentException(value + " not found in list");
    }
    if(head.getValue() == value) {
      insert(newValue);
      return;
    }
    Node current = head;
    Node insertNode = new Node(newValue);
    while(current.getNext() != null) {
      if(current.getNext().getValue() == value) {
        insertNode.setNext(current.getNext());
        current.setNext(insertNode);
        break;
      } else
      current = current.getNext();
    }
    if(current.getNext() == null)
      throw new IllegalArgumentException(value + " not found in list");
  }

  public void insertAfter(int value, int newValue) {
    if (head == null) {
      throw new IllegalArgumentException(value + " not found in list");
    }
    Node current = head;
    Node insertNode = new Node(newValue);
    while(current != null) {
      if(current.getValue() == value) {
        insertNode.setNext(current.getNext());
        current.setNext(insertNode);
        break;
      }
      current = current.getNext();
    }
    if(current == null)
      throw new IllegalArgumentException(value + " not found in list");
  }
}
