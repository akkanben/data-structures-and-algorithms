package datastructures.linkedlist;

public class Node<T> {
  private T value;
  private Node<T> next = null;

  Node(T value) {
    this.value = value;
  }

  Node() {
    //empty
  }

  public T getValue() {
    return value;
  }

  public Node<T> getNext() {
    return next;
  }

  public void setNext(Node<T> node ) {
    next = node;
  }
}
