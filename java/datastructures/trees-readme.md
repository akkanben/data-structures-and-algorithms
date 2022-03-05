# Trees

## Challenge

Implement a Node class and a Binary Tree class. Extend the Binary Tree class with a Binary Search Tree class.

### Requirements

- Construct Node class with a value, and left and right child nodes.. 
- Create methods for traversing the binary tree:
  - Pre order.
  - In order.
  - Post order.
- Extend the Binary Tree class with a Binary Search Tree and include an method for adding values and a method for seeing if a value is contained.

### Tests

1. Can successfully instantiate an empty tree
2. Can successfully instantiate a tree with a single root node
3. For a Binary Search Tree, can successfully add a left child and right child properly to a node
4. Can successfully return a collection from a preorder traversal
5. Can successfully return a collection from an inorder traversal
6. Can successfully return a collection from a postorder traversal
7. Returns true 	false for the contains method, given an existing or non-existing node value

## Approach & Efficiency

For traversal in Binary Trees has the time complexity of O(N) because we need to touch each node. This is the same for breadth first with a queue and depth first with recursion.

The space complexity when traversing Binary Trees using recursion is O(N) due to the stack frames increasing for each edge in the height of the tree. The space complexity for breadth with a queue is porportional to the width of the widest point in the tree, since that is the amount of nodes that will be in the queue at one time.

## API

### Binary Tree

**public T[] preOrderTraversal()** Returns an array in pre-order.

**public T[] inOrderTraversal()** Returns an array in-order.

**public T[] postOrderTraversal()** Returns an array in post-order.

**public T[] breadthFirstTraversal()** Returns an array in breadth first order.


### Binary Search Tree

**public void add(T value)** Adds a node with value to the correct position in the tree.

**public boolean contains(T value)** Returns true if the tree contains the specified value.

