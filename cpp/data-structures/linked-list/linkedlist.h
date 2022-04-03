#ifndef _linkedlist_h
#define _linkedlist_h

#include "node.h"
#include <sstream>
#include <stdexcept>
#include <string>
#include <unordered_map>

template <typename T> class LinkedList {
public:
  LinkedList();
  ~LinkedList();
  void insert(T value);
  void append(T value);
  void insertBefore(T value, T newData);
  void insertAfter(T value, T newData);
  void removeFirstOccurance(T value);
  void removeAllOccurances(T value);
  T kthFromEnd(int k);
  T kthFromEndWithSize(int k);
  bool includes(T value);
  int size();
  std::string toString();

private:
  Node<T> *head;
  int elementCount;
};

template <typename T> LinkedList<T>::LinkedList() {
  head = NULL;
  elementCount = 0;
}

template <typename T> LinkedList<T>::~LinkedList() {
  Node<T> *current = head;
  while (current != NULL) {
    Node<T> *temp = current;
    current = current->next;
    delete temp;
  }
}

template <typename T> void LinkedList<T>::insert(T value) {
  Node<T> *newHeadNode = new Node<T>(value);
  newHeadNode->next = head;
  head = newHeadNode;
  elementCount++;
}

template <typename T> void LinkedList<T>::append(T value) {
  Node<T> *newTailNode = new Node<T>(value);
  if (head == NULL) {
    head = newTailNode;
    elementCount++;
    return;
  }
  Node<T> *current = head;
  while (current->next != NULL) {
    current = current->next;
  }
  current->next = newTailNode;
  elementCount++;
}

template <typename T>
void LinkedList<T>::insertBefore(T targetValue, T newValue) {
  Node<T> *newNode = new Node<T>(newValue);
  if (head == NULL)
    throw std::invalid_argument(targetValue + " value not found in the list");
  if (head->value == targetValue) {
    insert(newValue);
    return;
  }
  Node<T> *current = head;
  while (current->next != NULL) {
    if (current->next->value == targetValue) {
      newNode->next = current->next;
      current->next = newNode;
      elementCount++;
      return;
    }
    current = current->next;
  }
  throw std::invalid_argument(targetValue + " value not found in the list");
}

template <typename T>
void LinkedList<T>::insertAfter(T targetValue, T newValue) {
  Node<T> *newNode = new Node<T>(newValue);
  if (head == NULL)
    throw std::invalid_argument(targetValue + " value not found in the list");
  Node<T> *current = head;
  while (current != NULL) {
    if (current->value == targetValue) {
      newNode->next = current->next;
      current->next = newNode;
      elementCount++;
      return;
    }
    current = current->next;
  }
  throw std::invalid_argument(targetValue + " value not found in the list");
}

template <typename T> void LinkedList<T>::removeFirstOccurance(T targetValue) {
  if (head == NULL)
    throw std::invalid_argument(targetValue + " value not found in the list");
  if (head->value == targetValue) {
    Node<T> *temp = head;
    head = head->next;
    delete temp;
    elementCount--;
    return;
  }
  Node<T> *current = head;
  while (current->next != NULL) {
    if (current->next->value == targetValue) {
      Node<T> *temp = current->next;
      current->next = current->next->next;
      delete temp;
      elementCount--;
      return;
    }
    current = current->next;
  }
  throw std::invalid_argument(targetValue + " value not found in the list");
}

template <typename T> void LinkedList<T>::removeAllOccurances(T targetValue) {
  if (head == NULL)
    throw std::invalid_argument(targetValue + " value not found in the list");
  bool foundOccurance = false;
  if (head->value == targetValue) {
    Node<T> *temp = head;
    head = head->next;
    delete temp;
    foundOccurance = true;
    elementCount--;
  }
  Node<T> *current = head;
  while (current->next != NULL) {
    if (current->next->value == targetValue) {
      Node<T> *temp = current->next;
      current->next = current->next->next;
      delete temp;
      foundOccurance = true;
      elementCount--;
    }
    current = current->next;
  }
  if (!foundOccurance)
    throw std::invalid_argument(targetValue + " value not found in the list");
}

template <typename T> T LinkedList<T>::kthFromEnd(int k) {
  if (head == NULL || k < 0)
    throw std::invalid_argument("position " + std::to_string(k) +
                                " is out of bounds");
  std::unordered_map<int, T> valueMap;
  Node<T> *current = head;
  int key = 0;
  while (current != NULL) {
    valueMap[key++] = current->value;
    current = current->next;
  }
  if (k >= valueMap.size())
    throw std::invalid_argument("position " + std::to_string(k) +
                                " is out of bounds");
  return (valueMap[valueMap.size() - 1 - k]);
}

template <typename T> T LinkedList<T>::kthFromEndWithSize(int k) {
  int targetPosition = elementCount - 1 - k;
  if (k < 0 || targetPosition < 0 || targetPosition >= elementCount)
    throw std::invalid_argument("position " + std::to_string(k) +
                                " is out of bounds");
  Node<T> *current = head;
  int position = 0;
  while (current != NULL) {
    if (position == targetPosition)
      return current->value;
    position++;
    current = current->next;
  }
  throw std::invalid_argument("position " + std::to_string(k) +
                              " is out of bounds");
}

template <typename T> bool LinkedList<T>::includes(T value) {
  Node<T> *current = head;
  while (current != NULL) {
    if (current->value == value)
      return true;
    current = current->next;
  }
  return false;
}

template <typename T> int LinkedList<T>::size() { return elementCount; }

template <typename T> std::string LinkedList<T>::toString() {
  Node<T> *current = head;
  std::ostringstream stream;

  while (current != NULL) {
    stream << "{ " << current->value << " } -> ";
    current = current->next;
  }
  stream << "NULL";
  return stream.str();
}

// for debugging in gdb
std::string &SSS(const char *s) { return *(new std::string(s)); }

#endif
