#include <cassert>
#include <iostream>
#include <string>

#include "linked-list/linkedlist.h"
#include "test-globals.h"

void test_size();
void test_insert_single();
void test_insert_multiple();

int main() {

  std::cout << "-------------------- LinkedList Unit Test --------------------" << std::endl;
  test_size();
  test_insert_single();
  test_insert_multiple();

  return 0;
}

void test_size() {
  LinkedList<std::string> *sut = new LinkedList<std::string>();
  sut->insert("hello");
  sut->insert("is");
  sut->insert("anyone");
  sut->insert("there?");
  assert(sut->size() == 4);
  std::cout << PASS_TEST << " Passing test_size()" << std::endl;
}

void test_insert_single() {
  LinkedList<int> *sut = new LinkedList<int>();
  sut->insert(5);
  assert(sut->getHead()->value == 5);
  assert(sut->getHead()->next == nullptr);
  assert(sut->includes(5));
  assert(sut->size() == 1);
  std::cout << PASS_TEST << " Passing test_insert()" << std::endl;
}

void test_insert_multiple() {
  LinkedList<int> *sut = new LinkedList<int>();
  sut->insert(-1000);
  sut->insert(0);
  sut->insert(100);
  sut->insert(-100);
  assert(sut->getHead()->value == -100);
  assert(sut->getHead()->next->value == 100);
  assert(sut->getHead()->next->next->value == 0);
  assert(sut->getHead()->next->next->next->value == -1000);
  assert(sut->getHead()->next->next->next->next == nullptr);
  assert(sut->size() == 4);
  assert(sut->includes(0));
  std::cout << PASS_TEST << " Passing test_multiple()" << std::endl;
}
