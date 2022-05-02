#ifndef _stack_h
#define _stack_h

#include "node.h"
#include <iostream>

template <typename T> class Stack {

public:
  Stack();
  ~Stack();
  void push(T value);
  T pop();
  T peek();
  bool isEmpty();

private:
  Node<T> *top;
  int size;
};

template <typename T> Stack<T>::Stack() {
  top = NULL;
  size = 0;
}

template <typename T> Stack<T>::~Stack() {
  Node<T> *current = top;
  while (current != NULL) {
    Node<T> *temp = current;
    current = current->next;
    delete temp;
  }
}

template <typename T> void Stack<T>::push(T value) {
  Node<T> *newTop = new Node<T>(value);
  newTop->next = top;
  ;
  top = newTop;
  size++;
}

template <typename T> T Stack<T>::pop() {
  Node<T> *temp = top;
  top = top.next;
  size--;
  return temp->value;
}

template <typename T> T Stack<T>::peek() { return top->value; }

template <typename T> bool Stack<T>::isEmpty() { return size == 0; }

#endif
