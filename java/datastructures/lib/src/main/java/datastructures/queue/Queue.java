package datastructures.queue;

public class Queue<T> {
  private Node<T> front = null;
  private Node<T> back = null;
  private int size = 0;

  public Queue() {
    // empty
  }

  public void enqueue(T value) {
    Node<T>  newNode = new Node<>(value);
    if(size == 0)
      front = newNode;
    else
      back.next = newNode;
    back = newNode;
    size++;
  }

  public T dequeue() {
    T output = front.value;
    front = front.next;
    size--;
    return output;
  }

  public T peek() {
    return front.value;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

}
