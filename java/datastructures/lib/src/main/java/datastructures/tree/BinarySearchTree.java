package datastructures.tree;

public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> {

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
            break;
          }
          current = current.left;
        }
        else {
          if (current.right == null) {
            current.right = newNode;
            break;
          }
          current = current.right;
        }
      }
    }
  }

}
