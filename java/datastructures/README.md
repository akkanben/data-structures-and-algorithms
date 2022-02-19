# Data Structures

## Singly Linked List

Linked lists are a data structure comprised of elements in linear series referred to as nodes. Each node is an structure or object with properties that hold data and a link to the next node in the series. Doubly linked lists also hold a link to the previous node. In a linked list the terminal node always has a link that points to null. This null link makes it possible to check if you are at the end of the list. The first node in the list is referred to as the head and it needs to be saved in order to know where the beginning of the list starts.

### Challenge

Implement a Singly Linked List with and insert(), includes() and toString() method. Write tests to ensure the class functions correctly:

1. Can successfully instantiate an empty linked list
2. Can properly insert into the linked list
3. The head property will properly point to the first node in the linked list
4. Can properly insert multiple nodes into the linked list
5. Will return true when finding a value within the linked list that exists
6. Will return false when searching for a value in the linked list that does not exist
7. Can properly return a collection of all the values that exist in the linked list

### Approach & Efficiency

Inserting into the list is O(1) because we can add it directly without any traversal. Traversing the list is O(N) in the worst case of traversing the entire list.

### API

**public void insert(int value)** The insert method takes an integer as an argument and adds this integer to the beginning of the linked list.

**public boolean includes(int value)** The includes method takes and integer as an argument and returns true if the integer value is found in the list.

**public String toString()** The toString method overides the default toString method and return a string representation of the elements in the linked list.

