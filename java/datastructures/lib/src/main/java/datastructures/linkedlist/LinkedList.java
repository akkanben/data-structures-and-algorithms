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
     output = "{ " + current.getValue() + " } -> " + output;
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

  public void insertBefore(int value) {
    //TODO
  }

  public void insertAfter(int value) {
   //TODO
  }

}
