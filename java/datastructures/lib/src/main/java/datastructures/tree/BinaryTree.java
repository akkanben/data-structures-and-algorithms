package datastructures.tree;

import datastructures.queue.Queue;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BinaryTree<T> {

  Node<T> root;

  public BinaryTree() {
    //empty;
  }

  public BinaryTree(Node<T> root) {
    this.root = root;
  }

  public T[] preOrderTraversal() {
    ArrayList<T> outputList = new ArrayList<>();
    preOrderAsList(outputList, root);
    return (T[]) outputList.toArray();
  }

  private void preOrderAsList(ArrayList<T> list, Node<T> localRoot) {
    list.add(localRoot.value);
    if (localRoot.left != null)
      preOrderAsList(list, localRoot.left);
    if (localRoot.right != null)
      preOrderAsList(list, localRoot.right);
  }

  public T[] inOrderTraversal() {
    ArrayList<T> outputList = new ArrayList<>();
    inOrderAsList(outputList, root);
    return (T[]) outputList.toArray();
  }

  public void inOrderAsList(ArrayList<T> list, Node<T> localRoot) {
    if (localRoot.left != null)
      inOrderAsList(list, localRoot.left);
    list.add(localRoot.value);
    if (localRoot.right != null)
      inOrderAsList(list, localRoot.right);
  }

  public T[] postOrderTraversal() {
    ArrayList<T> outputList = new ArrayList<>();
    postOrderAsList(outputList, root);
    return (T[]) outputList.toArray();
  }

  public void postOrderAsList(ArrayList<T> list, Node<T> root) {
    if (root.left != null)
      postOrderAsList(list, root.left);
    if (root.right != null)
      postOrderAsList(list, root.right);
    list.add(root.value);
  }

  public T[] breadthFirstTraversal() {
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
    return (T[]) outputList.toArray();
  }
}
