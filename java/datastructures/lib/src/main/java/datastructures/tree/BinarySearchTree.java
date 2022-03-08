package datastructures.tree;

public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree{

  public void add(T value) {
    Node<T> newNode = new Node<>(value);
    Node<T> current;
    if(root == null)
        root = newNode;
    else {
      current = root;
      while(current != null) {
        if(newNode.value.compareTo(current.value) == 0) // if newNode == current
          throw new IllegalArgumentException();
        if(newNode.value.compareTo(current.value) < 0 )  { // if newNode < current
          if (current.left == null) {
            current.left = newNode;
            return;
          }
          current = current.left;
        }
        else {
          if (current.right == null) {
            current.right = newNode;
            return;
          }
          current = current.right;
        }
      }
    }
  }

  public boolean contains(T value) {
    Node<T> current = root;
    while (current != null) {
      if (current.value.compareTo(value) == 0)
        return true;
      else if (current.value.compareTo(value) > 0) // if current > value
        current = current.left;
      else
        current = current.right;
    }
    return false;
  }
}
