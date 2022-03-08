package datastructures.tree;

public class Node<T> {

  public T value;
  public Node<T> left = null;
  public Node<T> right = null;

  public Node() {
    //empty
  }

  public Node(T value) {
    this.value = value;
  }

}
