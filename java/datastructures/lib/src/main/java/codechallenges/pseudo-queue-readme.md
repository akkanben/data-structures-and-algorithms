# Challenge Summary

Implement a Queue using two Stacks.

## Whiteboard Process

[![Whiteboard](../../../../../images/stack-queue-psuedo.png)](../../../../../images/stack-queue-psuedo.png)

<style>
  img {
    max-width: 80%;
  }
</style>


## Approach & Efficiency

To represent the Queue with two stacks I designated one stack as the front, the top value in this "front" stack will always be the front of the queue. The back stack is where new elements get pushed as they enter the queue. To dequeue if the front stack is empty, we need to push each value from the back stack onto the front stack (reversing them), then pop the top of the front.

Enqueue elements can be directly pushed onto the back stack and since the underlying stack has a time complexity of O(1) for pushing, this Pseudo queue has a O(1) time complexity for enqueue.

To dequeue the best case is O(1) but the worst case we need to pop each value from the back and push to the front creating O(N) time complexity.

Both methods do not use any other data structures and do not use more disk space as N increases: O(1).

## Code

```java
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
```

