package datastructures.stack;

public class Stack<T> {
  private Node<T> top = null;
  private int size = 0;

  public int size() {
    return size;
  }

  public void push(T value) {
    Node<T> newTop = new Node<>(value);
    newTop.next = top;
    top = newTop;
    size++;
  }

  public T pop() {
    Node<T> temp = top;
    top = top.next;
    size--;
    return temp.value;
  }

  public T peek() {
    return top.value;
  }

  public boolean isEmpty() {
    return size == 0;
  }

}
