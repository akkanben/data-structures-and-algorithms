#include <cassert>
#include <iostream>

#include "linked-list/linkedlist.h"
#include "test-globals.h"

void test_insert();

int main() {

  std::cout << "-------------------- LinkedList Unit Test --------------------" << std::endl;
  test_insert();

  return 0;
}

void test_insert() {
  LinkedList<int> *sut = new LinkedList<int>();
  sut->insert(5);
  assert(sut->getHead()->value == 4 && std::cout << FAIL_TEST << " failed" << std::endl);
  assert(sut->getHead()->next == nullptr);
  assert(sut->includes(5));
  std::cout << PASS_TEST << " Passing test_insert()" << std::endl;
}
