package datastructures.tree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

  @Test
  void test_add_one() {
    BinarySearchTree<Integer> sut = new BinarySearchTree<>();
    sut.add(5);
    assertEquals(sut.root.value, 5);
  }

  @Test
  void test_add_multiple() {
    BinarySearchTree<Integer> sut = new BinarySearchTree<>();
    sut.add(5);
    sut.add(3);
    sut.add(6);
    assertEquals(sut.root.value, 5);
    assertEquals(sut.root.left.value, 3);
    assertEquals(sut.root.right.value, 6);
  }

  @Test
  void test_add_multiple_all_less() {
    BinarySearchTree<Integer> sut = new BinarySearchTree<>();
    sut.add(5);
    sut.add(4);
    sut.add(3);
    sut.add(2);
    sut.add(1);
    assertEquals(sut.root.value, 5);
    assertEquals(sut.root.left.value, 4);
    assertEquals(sut.root.left.left.value, 3);
    assertEquals(sut.root.left.left.left.value, 2);
    assertEquals(sut.root.left.left.left.left.value, 1);
  }

  @Test
  void test_add_multiple_all_more() {
    BinarySearchTree<Integer> sut = new BinarySearchTree<>();
    sut.add(5);
    sut.add(6);
    sut.add(7);
    sut.add(8);
    sut.add(9);
    assertEquals(sut.root.value, 5);
    assertEquals(sut.root.right.value, 6);
    assertEquals(sut.root.right.right.value, 7);
    assertEquals(sut.root.right.right.right.value, 8);
    assertEquals(sut.root.right.right.right.right.value, 9);
  }

  @Test
  void test_contains_one() {
    BinarySearchTree<String> sut = new BinarySearchTree<>();
    sut.add("Hello");
    assertTrue(sut.contains("Hello"));
  }

  @Test
  void test_contains_many() {
    BinarySearchTree<Integer> sut = new BinarySearchTree<>();
    sut.add(5);
    sut.add(3);
    sut.add(2);
    sut.add(4);
    sut.add(8);
    sut.add(9);
    sut.add(7);
    //              (5)
    //             /   \
    //          (3)     (8)
    //         /   \   /   \
    //       (2)  (4) (7)  (9)
    assertTrue(sut.contains(5));
    assertTrue(sut.contains(3));
    assertTrue(sut.contains(2));
    assertTrue(sut.contains(4));
    assertTrue(sut.contains(8));
    assertTrue(sut.contains(9));
    assertTrue(sut.contains(7));
    assertFalse(sut.contains(10));
    assertFalse(sut.contains(-1));
    assertFalse(sut.contains(-100));
    assertFalse(sut.contains(30));
  }

  @Test
  void test_preordertraversal_confirm() {
    BinarySearchTree<Character> sut = new BinarySearchTree<>();
    sut.add('D');
    sut.add('B');
    sut.add('A');
    sut.add('C');
    sut.add('F');
    sut.add('E');
    sut.add('G');
    //              (D)
    //             /   \
    //          (B)     (F)
    //         /   \   /   \
    //       (A)  (C) (E)  (G)
    Character[] test = {'D', 'B', 'A', 'C', 'F', 'E', 'G'};
    assert(Arrays.equals(sut.preOrderTraversal(), test));
  }

  @Test
  void test_inordertraversal_confirm() {
    BinarySearchTree<Character> sut = new BinarySearchTree<>();
    sut.add('D');
    sut.add('B');
    sut.add('A');
    sut.add('C');
    sut.add('F');
    sut.add('E');
    sut.add('G');
    //              (D)
    //             /   \
    //          (B)     (F)
    //         /   \   /   \
    //       (A)  (C) (E)  (G)
    Character[] test = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
    assert(Arrays.equals(sut.inOrderTraversal(), test));
  }

  @Test
  void test_postordertraversal_confirm() {
    BinarySearchTree<Character> sut = new BinarySearchTree<>();
    sut.add('D');
    sut.add('B');
    sut.add('A');
    sut.add('C');
    sut.add('F');
    sut.add('E');
    sut.add('G');
    //              (D)
    //             /   \
    //          (B)     (F)
    //         /   \   /   \
    //       (A)  (C) (E)  (G)
    Character[] test = {'A', 'C', 'B', 'E', 'G', 'F', 'D'};
    assert(Arrays.equals(sut.postOrderTraversal(), test));
  }
}
