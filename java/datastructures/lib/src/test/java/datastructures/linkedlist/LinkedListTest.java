package datastructures.linkedlist;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

  @Test
  void test_instantiate_empty_list() {
    LinkedList<Integer> sut = new LinkedList<>();
    assert(sut.head == null);
  }

  @Test
  void test_insert() {
    LinkedList<Integer> sut = new LinkedList<>();
    sut.insert(5);
    assert(sut.includes(5));
  }

  @Test
  void test_head_points_to_first_node() {
    LinkedList<Integer> sut = new LinkedList<>();
    sut.insert(7);
    assert(sut.head.value == 7);
  }

  @Test
  void test_multiple_insert() {
    LinkedList<Integer> sut = new LinkedList<>();
    sut.insert(-2);
    sut.insert(-1);
    sut.insert(0);
    sut.insert(1);
    sut.insert(2);
    assert(sut.head.value == 2);
  }

  @Test
  void test_includes_true() {
    LinkedList<Integer> sut = new LinkedList<>();
    sut.insert(1001);
    sut.insert(1002);
    sut.insert(1003);
    System.out.println(sut);
    assert(sut.includes(1001));
    assert(sut.includes(1002));
    assert(sut.includes(1003));
  }

  @Test
  void test_includes_false() {
    LinkedList<Integer> sut = new LinkedList<>();
    sut.insert(0);
    sut.insert(-99999);
    sut.insert(45000);
    assert(!sut.includes(5));
    assert(!sut.includes(-6));
    assert(!sut.includes(89));
  }

  @Test
  void test_build_collection() {
    LinkedList<Integer> sut = new LinkedList<>();
    Integer[] testArray = {-2, -1, 0, 1, 2, 3, 4, 5, 6, 7};
    for (Integer element : testArray) {
      sut.insert(element);
    }
    Integer[] linkedListOutput = new Integer[testArray.length];
    int index = testArray.length - 1;
    Node current = sut.head;
    while(current != null) {
      linkedListOutput[index--] = (Integer)current.value;
      current = current.next;
    }
    assert(Arrays.equals(linkedListOutput, testArray));
  }

  @Test
  void test_insert_add_node_to_end_of_list() {
    LinkedList<Integer> sut = new LinkedList<>();
    sut.append(5);
    assert(sut.includes(5));
  }

  @Test
  void test_insert_add_multiple_nodes_to_end_of_list() {
    LinkedList<Integer> sut = new LinkedList<>();
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
    LinkedList<Integer> sut = new LinkedList<>();
    sut.append(100);
    sut.append(200);
    sut.append(400);
    sut.append(500);
    sut.insertBefore(400,300);
    assert(sut.toString().equals("{ 100 } -> { 200 } -> { 300 } -> { 400 } -> { 500 } -> NULL"));
  }

  @Test
  void test_insertbefore_first_node() {
    LinkedList<Integer> sut = new LinkedList<>();
    sut.append(0);
    sut.append(1);
    sut.append(2);
    sut.append(3);
    sut.insertBefore(0, -1);
    assert(sut.toString().equals("{ -1 } -> { 0 } -> { 1 } -> { 2 } -> { 3 } -> NULL"));
  }

  @Test
  void test_insertbefore_throws_method_exception() {
    LinkedList<Integer> sut = new LinkedList<>();
    assertThrows(IllegalArgumentException.class, () -> {
      sut.insertBefore(100,0);
    });
    sut.append(100);
    sut.append(200);
    sut.append(300);
    assertThrows(IllegalArgumentException.class, () -> {
      sut.insertBefore(1000,300);
    });
  }

  @Test
  void test_insertafter_middle_node() {
    LinkedList<Integer> sut = new LinkedList<>();
    sut.append(100);
    sut.append(200);
    sut.append(400);
    sut.append(500);
    sut.insertAfter(200,300);
    assert(sut.toString().equals("{ 100 } -> { 200 } -> { 300 } -> { 400 } -> { 500 } -> NULL"));
  }

  @Test
  void test_insertafter_last_node() {
    LinkedList<Integer> sut = new LinkedList<>();
    sut.append(-50);
    sut.append(-49);
    sut.append(-48);
    sut.append(-47);
    sut.insertAfter(-47,-46);
    assert(sut.toString().equals("{ -50 } -> { -49 } -> { -48 } -> { -47 } -> { -46 } -> NULL"));
  }

  @Test
  void test_insertafter_throws_method_exception() {
    LinkedList<Integer> sut = new LinkedList<>();
    assertThrows(IllegalArgumentException.class, () -> {
      sut.insertAfter(100,0);
    });
    sut.append(100);
    sut.append(200);
    sut.append(300);
    assertThrows(IllegalArgumentException.class, () -> {
      sut.insertAfter(1000,300);
    });
  }

  @Test
  void test_delete_first_node() {
    LinkedList<Integer> sut = new LinkedList<>();
    sut.append(1);
    sut.append(2);
    sut.append(3);
    sut.delete(1);
    assert(sut.toString().equals("{ 2 } -> { 3 } -> NULL"));
  }

  @Test
  void test_delete_last_node() {
    LinkedList<Integer> sut = new LinkedList<>();
    sut.append(1);
    sut.append(2);
    sut.append(3);
    sut.delete(3);
    assert(sut.toString().equals("{ 1 } -> { 2 } -> NULL"));
  }

  @Test
  void test_delete_middle_node() {
    LinkedList<Integer> sut = new LinkedList<>();
    sut.append(1);
    sut.append(2);
    sut.append(3);
    sut.delete(2);
    assert(sut.toString().equals("{ 1 } -> { 3 } -> NULL"));
  }

  @Test
  void test_delete_throws_method_exception() {
    LinkedList<Integer> sut = new LinkedList<>();
    assertThrows(IllegalArgumentException.class, () -> {
      sut.delete(1);
    });
    sut.append(1);
    sut.append(2);
    sut.append(3);
    assertThrows(IllegalArgumentException.class, () -> {
      sut.delete(0);
    });
  }

  @Test
  void test_kthfromend_too_large_k() {
    LinkedList<Integer> sut = new LinkedList<>();
    sut.append(1);
    sut.append(2);
    sut.append(3);
    assertThrows(IllegalArgumentException.class, () -> {
      sut.kthFromEnd(4);
    });
  }

  @Test
  void test_kthfromend_same_length_as_k() {
    LinkedList<Integer> sut = new LinkedList<>();
    sut.append(1);
    sut.append(2);
    sut.append(3);
    assertThrows(IllegalArgumentException.class, () -> {
      sut.kthFromEnd(3);
    });
  }

  @Test
  void test_kthfromend_negative_k() {
    LinkedList<Integer> sut = new LinkedList<>();
    sut.append(1);
    sut.append(2);
    sut.append(3);
    assertThrows(IllegalArgumentException.class, () -> {
      sut.kthFromEnd(-1);
    });
  }

  @Test
  void test_kthfromend_list_size_of_one() {
    LinkedList<Integer> sut = new LinkedList<>();
    sut.append(100);
    assert(sut.kthFromEnd(0) == 100);
  }

  @Test
  void test_kthfromend_happy_path_middle_k() {
    LinkedList<Integer> sut = new LinkedList<>();
    sut.append(-1);
    sut.append(0);
    sut.append(1);
    sut.append(2);
    sut.append(3);
    assert(sut.kthFromEnd(2) == 1);
  }

  @Test
  void test_kthfromendwithsize_too_large_k() {
    LinkedList<Integer> sut = new LinkedList<>();
    sut.append(1);
    sut.append(2);
    sut.append(3);
    assertThrows(IllegalArgumentException.class, () -> {
      sut.kthFromEndWithSize(4);
    });
  }

  @Test
  void test_kthfromendwithsize_same_length_as_k() {
    LinkedList<Integer> sut = new LinkedList<>();
    sut.append(1);
    sut.append(2);
    sut.append(3);
    assertThrows(IllegalArgumentException.class, () -> {
      sut.kthFromEndWithSize(3);
    });
  }

  @Test
  void test_kthfromendwithsize_negative_k() {
    LinkedList<Integer> sut = new LinkedList<>();
    sut.append(1);
    sut.append(2);
    sut.append(3);
    assertThrows(IllegalArgumentException.class, () -> {
      sut.kthFromEndWithSize(-1);
    });
  }

  @Test
  void test_kthfromendwithsize_list_size_of_one() {
    LinkedList<Integer> sut = new LinkedList<>();
    sut.append(100);
    assert(sut.kthFromEndWithSize(0) == 100);
  }

  @Test
  void test_kthfromendwithsize_happy_path_middle_k() {
    LinkedList<Integer> sut = new LinkedList<>();
    sut.append(-1);
    sut.append(0);
    sut.append(1);
    sut.append(2);
    sut.append(3);
    assert(sut.kthFromEndWithSize(2) == 1);
  }
}
