package codechallenges;

import datastructures.tree.BinaryTree;
import datastructures.tree.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TreeBreadthFirstTest {
  @Test
  void test_example_input() {
    TreeChallenges sut = new TreeChallenges();
    BinaryTree<Integer> tree = new BinaryTree<>();
    Node<Integer> a = new Node<>(2);
    Node<Integer> b = new Node<>(7);
    Node<Integer> c = new Node<>(5);
    Node<Integer> d = new Node<>(2);
    Node<Integer> e = new Node<>(6);
    Node<Integer> f = new Node<>(9);
    Node<Integer> g = new Node<>(5);
    Node<Integer> h = new Node<>(11);
    Node<Integer> i = new Node<>(4);
    //              (2)
    //             /   \
    //          (7)     (5)
    //         /   \       \
    //       (2)  (6)      (9)
    //           /   \     /
    //          (5) (11) (4)
    a.left = b;
    a.right = c;
    b.left = d;
    b.right = e;
    e.left = g;
    e.right = h;
    c.right = f;
    f.left = i;
    tree.root = a;
    ArrayList<Integer> target = new ArrayList<>(Arrays.asList(2,7,5,2,6,9,5,11,4));
    assertEquals(sut.breadthFirst(tree), target);
  }

  @Test
  void test_empty() {
    TreeChallenges sut = new TreeChallenges();
    BinaryTree<Integer> tree = new BinaryTree<>();
    assertEquals(sut.breadthFirst(tree), new ArrayList<Integer>());
  }

  @Test
  void test_single() {
    TreeChallenges sut = new TreeChallenges();
    BinaryTree<Integer> tree = new BinaryTree<>();
    Node<Integer> a = new Node<>(2);
    tree.root = a;
    assertEquals(sut.breadthFirst(tree), new ArrayList<>(List.of(2)));
  }

  @Test
  void test_all_left() {

    TreeChallenges sut = new TreeChallenges();
    BinaryTree<Integer> tree = new BinaryTree<>();
    Node<Integer> a = new Node<>(2);
    Node<Integer> b = new Node<>(7);
    Node<Integer> c = new Node<>(5);
    Node<Integer> d = new Node<>(2);
    Node<Integer> e = new Node<>(6);
    Node<Integer> f = new Node<>(9);
    Node<Integer> g = new Node<>(5);
    Node<Integer> h = new Node<>(11);
    Node<Integer> i = new Node<>(4);
    a.left = b;
    b.left= c;
    c.left = d;
    d.left = e;
    e.left= f;
    f.left= g;
    g.left = h;
    h.left = i;
    tree.root = a;
    ArrayList<Integer> target = new ArrayList<>(Arrays.asList(2,7,5,2,6,9,5,11,4));
    assertEquals(sut.breadthFirst(tree), target);
  }

}
