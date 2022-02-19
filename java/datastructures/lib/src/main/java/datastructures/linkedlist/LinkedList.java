package datastructures.linkedlist;

public class LinkedList {
  Node head = null;

  public void insert(int value) {
    Node newHeadNode = new Node(value);
    newHeadNode.setNext(head);
    head = newHeadNode;
  }

  public boolean includes(int value) {
    Node current = head;
    while(current != null) {
      if(current.getValue() == value)
        return true;
      current = current.getNext();
    }
    return false;
  }

  @Override
  public String toString() {
    String output = "";
    Node current = head;
    while(current != null) {
     output = "{ " + current.getValue() + " } -> " + output;
     current = current.getNext();
    }
    return output + "NULL";
  }

}
