#ifndef _linkedlist_h
#define _linkedlist_h

#include "node.h"
#include <sstream>
#include <string>

template <typename ValueType> class LinkedList {
public:
  LinkedList();
  ~LinkedList();
  void insert(ValueType value);
  void append(ValueType value);
  void insertBefore(ValueType value, ValueType newData);
  bool includes(ValueType value);
  int size();
  std::string toString();

private:
  Node<ValueType> *head;
  int elementCount;
};

template <typename ValueType> LinkedList<ValueType>::LinkedList() {
  head = NULL;
  elementCount = 0;
}

template <typename ValueType> LinkedList<ValueType>::~LinkedList() {
  Node<ValueType> *current = head;
  while (current != NULL) {
    Node<ValueType> *temp = current;
    current = current->next;
    delete temp;
  }
}

template <typename ValueType>
void LinkedList<ValueType>::insert(ValueType value) {
  Node<ValueType> *newHeadNode = new Node<ValueType>(value);
  newHeadNode->next = head;
  head = newHeadNode;
  elementCount++;
}

template <typename ValueType>
void LinkedList<ValueType>::append(ValueType value) {
  Node<ValueType> *newTailNode = new Node<ValueType>(value);
  if (head == NULL) {
    head = newTailNode;
    elementCount++;
    return;
  }
  Node<ValueType> *current = head;
  while (current->next != NULL) {
    current = current->next;
  }
  current->next = newTailNode;
  elementCount++;
}

template <typename ValueType>
void LinkedList<ValueType>::insertBefore(ValueType targetValue,
                                         ValueType newValue) {
  Node<ValueType> *newNode = new Node<ValueType>(newValue);
  if (head == NULL)
    throw std::invalid_argument(targetValue + " value not found in the list");
  if (head->value == targetValue) {
    insert(newValue);
    return;
  }
  Node<ValueType> *current = head;
  while (current->next != NULL) {
    if (current->next->value == targetValue) {
      newNode->next = current->next;
      current->next = newNode;
      elementCount++;
      return;
    } else
      current = current->next;
  }
  throw std::invalid_argument(targetValue + " value not found in the list");
}

template <typename ValueType>
bool LinkedList<ValueType>::includes(ValueType value) {
  Node<ValueType> *current = head;
  while (current != NULL) {
    if (current->value == value)
      return true;
    current = current->next;
  }
  return false;
}

template <typename ValueType> int LinkedList<ValueType>::size() {
  return elementCount;
}

template <typename ValueType> std::string LinkedList<ValueType>::toString() {
  Node<ValueType> *current = head;
  std::ostringstream stream;

  while (current != NULL) {
    stream << "{ " << current->value << " } -> ";
    current = current->next;
  }
  stream << "NULL";
  return stream.str();
}

#endif
