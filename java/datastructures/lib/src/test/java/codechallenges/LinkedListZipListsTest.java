package codechallenges;

import datastructures.linkedlist.LinkedList;
import org.junit.jupiter.api.Test;

public class LinkedListZipListsTest {

  @Test
  void test_ziplists_example_one_happy_path() {
    LinkedListChallenges sut = new LinkedListChallenges();
    LinkedList<Integer> list1 = new LinkedList<>();
    LinkedList<Integer> list2 = new LinkedList<>();
    list1.append(1);
    list1.append(3);
    list1.append(2);
    list2.append(5);
    list2.append(9);
    list2.append(4);
    assert(sut.zipLists(list1, list2).toString().equals("{ 1 } -> { 5 } -> { 3 } -> { 9 } -> { 2 } -> { 4 } -> NULL"));
  }

  @Test
  void test_ziplists_example_two_list1_short() {
    LinkedListChallenges sut = new LinkedListChallenges();
    LinkedList<Integer> list1 = new LinkedList<>();
    LinkedList<Integer> list2 = new LinkedList<>();
    list1.append(1);
    list1.append(3);
    list2.append(5);
    list2.append(9);
    list2.append(4);
    assert(sut.zipLists(list1, list2).toString().equals("{ 1 } -> { 5 } -> { 3 } -> { 9 } -> { 4 } -> NULL"));
  }

  @Test
  void test_ziplists_example_three_list2_short() {
    LinkedListChallenges sut = new LinkedListChallenges();
    LinkedList<Integer> list1 = new LinkedList<>();
    LinkedList<Integer> list2 = new LinkedList<>();
    list1.append(1);
    list1.append(3);
    list1.append(2);
    list2.append(5);
    list2.append(9);
    assert(sut.zipLists(list1, list2).toString().equals("{ 1 } -> { 5 } -> { 3 } -> { 9 } -> { 2 } -> NULL"));
  }

  @Test
  void test_ziplists_list1_empty() {
    LinkedListChallenges sut = new LinkedListChallenges();
    LinkedList<Integer> list1 = new LinkedList<>();
    LinkedList<Integer> list2 = new LinkedList<>();
    list2.append(5);
    list2.append(9);
    list2.append(4);
    assert(sut.zipLists(list1, list2).toString().equals("{ 5 } -> { 9 } -> { 4 } -> NULL"));
  }

  @Test
  void test_ziplists_list2_empty() {
    LinkedListChallenges sut = new LinkedListChallenges();
    LinkedList<Integer> list1 = new LinkedList<>();
    LinkedList<Integer> list2 = new LinkedList<>();
    list1.append(1);
    list1.append(3);
    list1.append(2);
    assert(sut.zipLists(list1, list2).toString().equals("{ 1 } -> { 3 } -> { 2 } -> NULL"));
  }

  @Test
  void test_ziplists_both_empty() {
    LinkedListChallenges sut = new LinkedListChallenges();
    LinkedList<Integer> list1 = new LinkedList<>();
    LinkedList<Integer> list2 = new LinkedList<>();
    assert(sut.zipLists(list1, list2).toString().equals("NULL"));
  }

  // Stretch Goal

  @Test
  void test_zipsortedlistssorted_happypath() {
    LinkedListChallenges sut = new LinkedListChallenges();
    LinkedList<Integer> list1 = new LinkedList<>();
    LinkedList<Integer> list2 = new LinkedList<>();
    list1.append(5);
    list1.append(7);
    list1.append(9);
    list2.append(6);
    list2.append(8);
    list2.append(10);
    assert(sut.zipSortedListsSorted(list1, list2).toString()
      .equals("{ 5 } -> { 6 } -> { 7 } -> { 8 } -> { 9 } -> { 10 } -> NULL"));
  }

  @Test
  void test_zipsortedlistssorted_list2_all_smaller() {
    LinkedListChallenges sut = new LinkedListChallenges();
    LinkedList<Integer> list1 = new LinkedList<>();
    LinkedList<Integer> list2 = new LinkedList<>();
    list1.append(10);
    list1.append(20);
    list1.append(30);
    list2.append(5);
    list2.append(6);
    list2.append(7);
    assert(sut.zipSortedListsSorted(list1, list2).toString()
      .equals("{ 5 } -> { 6 } -> { 7 } -> { 10 } -> { 20 } -> { 30 } -> NULL"));
  }

  @Test
  void test_zipsortedlistssorted_list1_all_smaller() {
    LinkedListChallenges sut = new LinkedListChallenges();
    LinkedList<Integer> list1 = new LinkedList<>();
    LinkedList<Integer> list2 = new LinkedList<>();
    list1.append(-2);
    list1.append(-1);
    list1.append(0);
    list2.append(1);
    list2.append(2);
    list2.append(3);
    assert(sut.zipSortedListsSorted(list1, list2).toString()
      .equals("{ -2 } -> { -1 } -> { 0 } -> { 1 } -> { 2 } -> { 3 } -> NULL"));
  }
}
