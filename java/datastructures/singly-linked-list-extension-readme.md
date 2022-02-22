# Extending a Singly Linked List Implementation


## Challenge

Extend a singly linked list to include and "append", "insert before", and "insert after" method.

**Required Unit Tests**

1. Can successfully add a node to the end of the linked list
2. Can successfully add multiple nodes to the end of a linked list
3. Can successfully insert a node before a node located i the middle of a linked list
4. Can successfully insert a node before the first node of a linked list
5. Can successfully insert after a node in the middle of the linked list
6. Can successfully insert a node after the last node of the linked list

**


## Approach & Efficiency

Inserting into the list is O(1) because we can add it directly without any traversal. Traversing the list is O(N) in the worst case of traversing the entire list.

## API

**public void insert(int value)** The insert method takes an integer as an argument and adds this integer to the beginning of the linked list.

**public boolean includes(int value)** The includes method takes and integer as an argument and returns true if the integer value is found in the list.

**public String toString()** The toString method overides the default toString method and return a string representation of the elements in the linked list.

