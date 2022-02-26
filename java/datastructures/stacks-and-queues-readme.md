# Stacks and Queues


## Challenge

Using a Linked List as the underlying data storage mechanism, implement both a Stack and a Queue.

### Requirements

- Construct Node classes to be used as underlying structures for the Stack class and the Queue class. 
- Create methods for stack and queue to add and remove elements. 
- Create a method to return the top of the stack or the front of the queue without returning it.
- Create a method to determine if the stack/queue is empty.

### Tests

1. Can successfully push onto a stack
2. Can successfully push multiple values onto a stack
3. Can successfully pop off the stack
4. Can successfully empty a stack after multiple pops
5. Can successfully peek the next item on the stack
6. Can successfully instantiate an empty stack
7. Calling pop or peek on empty stack raises exception
8. Can successfully enqueue into a queue
9. Can successfully enqueue multiple values into a queue
10. Can successfully dequeue out of a queue the expected value
11. Can successfully peek into a queue, seeing the expected value
12. Can successfully empty a queue after multiple dequeues
13. Can successfully instantiate an empty queue
14. Calling dequeue or peek on empty queue raises exception

## Approach & Efficiency

Because there is no traversal involved working with a stack or a queue all the method's time complexities are linear O(1).

## API

### Stack

**public Stack()** Instantiates an empty stack object.

**public void push(T value)** Adds a new element to the top of the stack.

**public T pop()** Returns the top element's value on the stack and removes it from the stack.

**public T peek()** Returns the top element's value on the stack but does not remove it from the stack.

**public boolean isEmpty()** Returns true if the stack is empty.

**public int size()** Returns the number of elements on the stack.

### Queue

**public Queue()** Instantiates an empty queue object.

**public void push(T value)** Adds a new element to the back of the queue.

**public T pop()** Returns the top element's value on the queue and removes it from the queue.

**public T peek()** Returns the top element's value on the queue but does not remove it form the queue.

**public boolean isEmpty()** Returns true if the queue is empty.

**public int size()** Returns the number of element on the queue.
