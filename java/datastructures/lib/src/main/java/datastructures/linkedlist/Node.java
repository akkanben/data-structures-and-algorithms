package datastructures.linkedlist;

public class Node {
  private int value;
  private Node next = null;

  Node(int value) {
    this.value = value;
  }

  Node() {
    //empty
  }

  public int getValue() {
    return value;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node node ) {
    next = node;
  }
}
