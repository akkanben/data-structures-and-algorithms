package datastructures.linkedlist;

public class Node {
  private int value;
  private Node next = null;

  Node(int value) {
    this.value = value;
  }
  
  public int getValue() {
    return value;
  }

  public Node getNext() {
    return next;
  }
}
