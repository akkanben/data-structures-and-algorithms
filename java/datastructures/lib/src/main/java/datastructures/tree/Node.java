package datastructures.tree;

public class Node<T> {

  T value;
  Node<T> left = null;
  Node<T> right = null;

  public Node() {
    //empty
  }

  public Node(T value) {
    this.value = value;
  }

}
