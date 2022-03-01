package codechallenges;

import datastructures.stack.Stack;

public class PseudoQueue<T> {

  public Stack<T> back;
  public Stack<T> front;

  PseudoQueue() {
    back = new Stack<>();
    front = new Stack<>();
  }

  T dequeue() {
    if (front.isEmpty()) {
      while(!back.isEmpty()) {
        front.push(back.pop());
      }
    }
    return front.pop();
  }

  void enqueue(T value) {
    back.push(value);
  }

}
