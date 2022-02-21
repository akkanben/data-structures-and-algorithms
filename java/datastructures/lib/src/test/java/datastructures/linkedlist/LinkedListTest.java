package datastructures.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

  @Test
  void test_instantiate_empty_list() {
    LinkedList sut = new LinkedList();
    assert(sut.head == null);
  }

  @Test
  void test_insert() {
    LinkedList sut = new LinkedList();
    sut.insert(5);
    assert(sut.includes(5));
  }

  @Test
  void test_head_points_to_first_node() {
    LinkedList sut = new LinkedList();
    sut.insert(7);
    assert(sut.head.getValue() == 7);
  }

  @Test
  void test_multiple_insert() {
    LinkedList sut = new LinkedList();
    sut.insert(-2);
    sut.insert(-1);
    sut.insert(0);
    sut.insert(1);
    sut.insert(2);
    assert(sut.head.getValue() == 2);
  }

  @Test
  void test_includes_true() {
    LinkedList sut = new LinkedList();
    sut.insert(1001);
    sut.insert(1002);
    sut.insert(1003);
    assert(sut.includes(1001));
    assert(sut.includes(1002));
    assert(sut.includes(1003));
  }

  @Test
  void test_includes_false() {
    LinkedList sut = new LinkedList();
    sut.insert(0);
    sut.insert(-99999);
    sut.insert(45000);
    assert(!sut.includes(5));
    assert(!sut.includes(-6));
    assert(!sut.includes(89));
  }

  @Test
  void test_build_collection() {
    LinkedList sut = new LinkedList();
    int[] testArray = {-2, -1, 0, 1, 2, 3, 4, 5, 6, 7};
    for (int element : testArray) {
      sut.insert(element);
    }
    int[] linkedListOutput = new int[testArray.length];
    int index = testArray.length - 1;
    Node current = sut.head;
    while(current != null) {
      linkedListOutput[index--] = current.getValue();
      current = current.getNext();
    }
    assert(Arrays.equals(linkedListOutput, testArray));
  }

  @Test
  void test_insert_add_node_to_end_of_list() {
    LinkedList sut = new LinkedList();
    sut.append(5);
    assert(sut.includes(5));
  }

  @Test
  void test_insert_add_multiple_nodes_to_end_of_list() {
    LinkedList sut = new LinkedList();
    sut.append(-1000);
    sut.append(-2000);
    sut.append(-3000);
    sut.append(-4000);
    assert(sut.includes(-1000));
    assert(sut.includes(-4000));
    assert(!sut.includes(-5000));
  }

  @Test
  void test_insertbefore_middle_node() {
    LinkedList sut = new LinkedList();
    sut.append(100);
    sut.append(200);
    sut.append(400);
    sut.append(500);
    sut.insertBefore(500,300);
    assert(sut.toString().equals("{ 100 } -> { 200 } -> { 400 } -> { 300 } -> { 500 } -> NULL"));
  }

  @Test
  void test_insertbefore_first_node() {
    LinkedList sut = new LinkedList();
    sut.append(0);
    sut.append(1);
    sut.append(2);
    sut.append(3);
    sut.insertBefore(0, -1);
    System.out.println(sut);

  }

  @Test
  void test_insertbefore_throws_method_exception() {
    LinkedList sut = new LinkedList();
    sut.append(100);
    sut.append(200);
    sut.append(300);
    assertThrows(IllegalArgumentException.class, () -> {
      sut.insertBefore(1000,300);
    });
  }
}
