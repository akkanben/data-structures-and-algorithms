#ifndef _node_h
#define _node_h

#include <iostream>

template <typename ValueType> struct Node {
  Node(ValueType value_);
  ValueType value;
  Node<ValueType> *next;
};

template <typename ValueType> Node<ValueType>::Node(ValueType value_) {
  value = value_;
  next = NULL;
};

#endif
