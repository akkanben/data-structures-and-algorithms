#ifndef _node_h
#define _node_h

#include <iostream>

template <typename T> struct Node {
  Node(T value_);
  T value;
  Node<T> *next;
};

template <typename T> Node<T>::Node(T value_) {
  value = value_;
  next = NULL;
};

#endif
