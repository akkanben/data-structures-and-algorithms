package datastructures.tree;

import datastructures.queue.Queue;

public class BinaryTree<T> {


  public BinaryTree() {
    //empty;
  }

  public void preOrderTraversal(Node<T> root) {
    System.out.print(root.value + " ");
    if (root.left != null)
      preOrderTraversal(root.left);
    if (root.right != null)
      preOrderTraversal(root.right);
  }

  public void inOrderTraversal(Node<T> root) {
    if (root.left != null)
      preOrderTraversal(root.left);
    System.out.print(root.value + " ");
    if (root.right != null)
      preOrderTraversal(root.right);
  }

  public void postOrderTraversal(Node<T> root) {
    if (root.left != null)
      preOrderTraversal(root.left);
    if (root.right != null)
      preOrderTraversal(root.right);
    System.out.print(root.value + " ");
  }

  public void breadthFirstTraversal(Node<T> root) {
    Queue<Node<T>> breadthQueue = new Queue<>();
    breadthQueue.enqueue(root);
    Node<T> front;
    while(!breadthQueue.isEmpty()) {
      front = breadthQueue.dequeue();
      System.out.print(front.value + " ");
      if (front.left != null)
        breadthQueue.enqueue(front.left);
      if (front.right != null)
        breadthQueue.enqueue(front.right);
    }
  }
}
