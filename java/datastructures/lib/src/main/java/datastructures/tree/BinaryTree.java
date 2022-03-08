package datastructures.tree;

import datastructures.queue.Queue;

import java.util.ArrayList;

public class BinaryTree<T extends Comparable<T>> {

  Node<T> root;

  public BinaryTree() {
    //empty;
  }

  public BinaryTree(Node<T> root) {
    this.root = root;
  }

  public Object[] preOrderTraversal() {
    ArrayList<T> outputList = new ArrayList<>();
    preOrderAsList(outputList, root);
    return outputList.toArray();
  }

  private void preOrderAsList(ArrayList<T> list, Node<T> localRoot) {
    list.add(localRoot.value);
    if (localRoot.left != null)
      preOrderAsList(list, localRoot.left);
    if (localRoot.right != null)
      preOrderAsList(list, localRoot.right);
  }

  public Object[] inOrderTraversal() {
    ArrayList<T> outputList = new ArrayList<>();
    inOrderAsList(outputList, root);
    return outputList.toArray();
  }

  private void inOrderAsList(ArrayList<T> list, Node<T> localRoot) {
    if (localRoot.left != null)
      inOrderAsList(list, localRoot.left);
    list.add(localRoot.value);
    if (localRoot.right != null)
      inOrderAsList(list, localRoot.right);
  }

  public Object[] postOrderTraversal() {
    ArrayList<T> outputList = new ArrayList<>();
    postOrderAsList(outputList, root);
    return  outputList.toArray();
  }

  private void postOrderAsList(ArrayList<T> list, Node<T> root) {
    if (root.left != null)
      postOrderAsList(list, root.left);
    if (root.right != null)
      postOrderAsList(list, root.right);
    list.add(root.value);
  }

  public Object[] breadthFirstTraversal() {
    ArrayList<T> outputList = new ArrayList<>();
    Queue<Node<T>> breadthQueue = new Queue<>();
    breadthQueue.enqueue(root);
    Node<T> front;
    while (!breadthQueue.isEmpty()) {
      front = breadthQueue.dequeue();
      outputList.add(front.value);
      if (front.left != null)
        breadthQueue.enqueue(front.left);
      if (front.right != null)
        breadthQueue.enqueue(front.right);
    }
    return outputList.toArray();
  }

  public T max() {
    if (root == null)
      throw new IllegalArgumentException();
    Queue<Node<T>> queue = new Queue<>();
    queue.enqueue((Node<T>) root);
    T max = (T) root.value;
    while(!queue.isEmpty()) {
      Node<T> temp = queue.dequeue();
      if (temp.value.compareTo(max) > 0)
        max = temp.value;
      if ( temp.left != null)
        queue.enqueue(temp.left);
      if (temp.right != null)
        queue.enqueue(temp.right);
    }
    return max;
  }

}
