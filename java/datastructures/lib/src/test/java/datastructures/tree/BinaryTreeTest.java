package datastructures.tree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

  @Test
  void test_constructor_empty_tree() {
    BinaryTree<Integer> sut = new BinaryTree<>();
    assertNotNull(sut);
  }

  @Test
  void test_constructor_single_node() {
    Node<Double> pi = new Node<>(3.14159);
    BinaryTree<Double> sut = new BinaryTree<Double>(pi);
    assertNotNull(sut);
    assertEquals(sut.root.value, 3.14159);
  }

  @Test
  void test_setting_single_left_right() {
    Node<String> a = new Node<>("A");
    Node<String> b = new Node<>("B");
    Node<String> c = new Node<>("C");
    BinaryTree<String> sut = new BinaryTree<>(a);
    a.left = b;
    a.right = c;
    //              (A)
    //             /   \
    //          (B)     (C)
    assertEquals(sut.root.value, "A");
    assertEquals(sut.root.left.value, "B");
    assertEquals(sut.root.right.value, "C");
  }

  @Test
  void test_preordertraversal() {
    BinaryTree<String> sut = new BinaryTree<>();
    Node<String> a = new Node<>("A");
    Node<String> b = new Node<>("B");
    Node<String> c = new Node<>("C");
    Node<String> d = new Node<>("D");
    Node<String> e = new Node<>("E");
    Node<String> f = new Node<>("F");
    Node<String> g = new Node<>("G");
    a.left = b;
    a.right = c;
    b.left = d;
    b.right = e;
    c.left = f;
    c.right = g;
    sut.root = a;
    //              (A)
    //             /   \
    //          (B)     (E)
    //         /   \   /   \
    //       (C)  (D) (F)  (G)
    String[] test = {"A", "B", "D", "E", "C", "F", "G"};
    assert(Arrays.equals(sut.preOrderTraversal(), test));
  }

  @Test
  void test_inordertraversal() {
    BinaryTree<String> sut = new BinaryTree<>();
    Node<String> a = new Node<>("A");
    Node<String> b = new Node<>("B");
    Node<String> c = new Node<>("C");
    Node<String> d = new Node<>("D");
    Node<String> e = new Node<>("E");
    Node<String> f = new Node<>("F");
    Node<String> g = new Node<>("G");
    a.left = b;
    a.right = c;
    b.left = d;
    b.right = e;
    c.left = f;
    c.right = g;
    sut.root = a;
    //              (A)
    //             /   \
    //          (B)     (E)
    //         /   \   /   \
    //       (C)  (D) (F)  (G)
    String[] test = {"D", "B", "E", "A", "F", "C", "G"};
    assert(Arrays.equals(sut.inOrderTraversal(), test));
  }

  @Test
  void test_postordertraversal() {
    BinaryTree<String> sut = new BinaryTree<>();
    Node<String> a = new Node<>("A");
    Node<String> b = new Node<>("B");
    Node<String> c = new Node<>("C");
    Node<String> d = new Node<>("D");
    Node<String> e = new Node<>("E");
    Node<String> f = new Node<>("F");
    Node<String> g = new Node<>("G");
    a.left = b;
    a.right = c;
    b.left = d;
    b.right = e;
    c.left = f;
    c.right = g;
    sut.root = a;
    //              (A)
    //             /   \
    //          (B)     (E)
    //         /   \   /   \
    //       (C)  (D) (F)  (G)
    String[] test = {"D", "E", "B", "F", "G", "C", "A"};
    assert(Arrays.equals(sut.postOrderTraversal(), test));
    System.out.println(Arrays.toString(sut.breadthFirstTraversal()));
  }

  @Test
  void test_breadthfirsttraversal() {
    BinaryTree<String> sut = new BinaryTree<>();
    Node<String> a = new Node<>("A");
    Node<String> b = new Node<>("B");
    Node<String> c = new Node<>("C");
    Node<String> d = new Node<>("D");
    Node<String> e = new Node<>("E");
    Node<String> f = new Node<>("F");
    Node<String> g = new Node<>("G");
    a.left = b;
    a.right = c;
    b.left = d;
    b.right = e;
    c.left = f;
    c.right = g;
    sut.root = a;
    //              (A)
    //             /   \
    //          (B)     (E)
    //         /   \   /   \
    //       (C)  (D) (F)  (G)
    String[] test = {"A", "B", "C", "D", "E", "F", "G"};
    assert(Arrays.equals(sut.breadthFirstTraversal(), test));
  }
}
