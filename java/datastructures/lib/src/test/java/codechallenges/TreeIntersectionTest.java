package codechallenges;

import codechallenges.TreeIntersection.TreeIntersection;
import datastructures.tree.BinaryTree;
import datastructures.tree.Node;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeIntersectionTest {

  @Test
  void example() {
    TreeIntersection sut = new TreeIntersection();
    BinaryTree<Integer> treeA = new BinaryTree<>();
    Node<Integer> a1 = new Node<>(150);
    Node<Integer> b1 = new Node<>(100);
    Node<Integer> c1 = new Node<>(250);
    Node<Integer> d1 = new Node<>(75);
    Node<Integer> e1 = new Node<>(160);
    Node<Integer> f1 = new Node<>(125);
    Node<Integer> g1 = new Node<>(175);
    Node<Integer> h1 = new Node<>(200);
    Node<Integer> i1 = new Node<>(350);
    Node<Integer> j1 = new Node<>(300);
    Node<Integer> k1 = new Node<>(500);
    //              (150)
    //             /     \
    //         (100)     (250)
    //         /   \     /   \
    //      (75) (160) (200) (350)
    //           /   \       /    \
    //        (125) (175)  (300) (500)
    a1.left = b1;
    a1.right = c1;
    b1.left = d1;
    b1.right = e1;
    e1.left = f1;
    e1.right = g1;
    c1.left = h1;
    c1.right = i1;
    i1.left = j1;
    i1.right = k1;
    treeA.root = a1;

    BinaryTree<Integer> treeB = new BinaryTree<>();
    Node<Integer> a2 = new Node<>(42);
    Node<Integer> b2 = new Node<>(100);
    Node<Integer> c2 = new Node<>(600);
    Node<Integer> d2 = new Node<>(15);
    Node<Integer> e2 = new Node<>(160);
    Node<Integer> f2 = new Node<>(125);
    Node<Integer> g2 = new Node<>(175);
    Node<Integer> h2 = new Node<>(200);
    Node<Integer> i2 = new Node<>(350);
    Node<Integer> j2 = new Node<>(4);
    Node<Integer> k2 = new Node<>(500);
    //              (42)
    //             /     \
    //         (100)     (600)
    //         /   \     /   \
    //      (15) (160) (200) (350)
    //           /   \       /    \
    //        (125) (175)  (4) (500)
    a2.left = b2;
    a2.right = c2;
    b2.left = d2;
    b2.right = e2;
    e2.left = f2;
    e2.right = g2;
    c2.left = h2;
    c2.right = i2;
    i2.left = j2;
    i2.right = k2;
    treeB.root = a2;
    ArrayList<Integer> testList = sut.tree_intersection(treeA, treeB);
    Collections.sort(testList);
    assertEquals(testList.toString(), "[100, 125, 160, 175, 200, 350, 500]");
  }

  @Test
  void one_empty() {
    TreeIntersection sut = new TreeIntersection();
    BinaryTree<Integer> treeA = new BinaryTree<>();
    Node<Integer> a1 = new Node<>(150);
    Node<Integer> b1 = new Node<>(100);
    Node<Integer> c1 = new Node<>(250);
    Node<Integer> d1 = new Node<>(75);
    Node<Integer> e1 = new Node<>(160);
    Node<Integer> f1 = new Node<>(125);
    Node<Integer> g1 = new Node<>(175);
    Node<Integer> h1 = new Node<>(200);
    Node<Integer> i1 = new Node<>(350);
    Node<Integer> j1 = new Node<>(300);
    Node<Integer> k1 = new Node<>(500);
    //              (150)
    //             /     \
    //         (100)     (250)
    //         /   \     /   \
    //      (75) (160) (200) (350)
    //           /   \       /    \
    //        (125) (175)  (300) (500)
    a1.left = b1;
    a1.right = c1;
    b1.left = d1;
    b1.right = e1;
    e1.left = f1;
    e1.right = g1;
    c1.left = h1;
    c1.right = i1;
    i1.left = j1;
    i1.right = k1;
    treeA.root = a1;

    BinaryTree<Integer> treeB = new BinaryTree<>();
    ArrayList<Integer> testList = sut.tree_intersection(treeA, treeB);
    Collections.sort(testList);
    assertEquals(testList.toString(), "[]");
  }

  @Test
  void both_empty() {
    TreeIntersection sut = new TreeIntersection();
    BinaryTree<Integer> treeA = new BinaryTree<>();
    BinaryTree<Integer> treeB = new BinaryTree<>();
    ArrayList<Integer> testList = sut.tree_intersection(treeA, treeB);
    Collections.sort(testList);
    assertEquals(testList.toString(), "[]");
  }

  @Test
  void no_matches() {

    TreeIntersection sut = new TreeIntersection();
    BinaryTree<Integer> treeA = new BinaryTree<>();
    Node<Integer> a1 = new Node<>(150);
    Node<Integer> b1 = new Node<>(100);
    Node<Integer> c1 = new Node<>(250);
    Node<Integer> d1 = new Node<>(75);
    Node<Integer> e1 = new Node<>(160);
    Node<Integer> f1 = new Node<>(125);
    Node<Integer> g1 = new Node<>(175);
    Node<Integer> h1 = new Node<>(200);
    Node<Integer> i1 = new Node<>(350);
    Node<Integer> j1 = new Node<>(300);
    Node<Integer> k1 = new Node<>(500);
    //              (150)
    //             /     \
    //         (100)     (250)
    //         /   \     /   \
    //      (75) (160) (200) (350)
    //           /   \       /    \
    //        (125) (175)  (300) (500)
    a1.left = b1;
    a1.right = c1;
    b1.left = d1;
    b1.right = e1;
    e1.left = f1;
    e1.right = g1;
    c1.left = h1;
    c1.right = i1;
    i1.left = j1;
    i1.right = k1;
    treeA.root = a1;

    BinaryTree<Integer> treeB = new BinaryTree<>();
    Node<Integer> a2 = new Node<>(2);
    Node<Integer> b2 = new Node<>(0);
    Node<Integer> c2 = new Node<>(8);
    Node<Integer> d2 = new Node<>(1);
    Node<Integer> e2 = new Node<>(5);
    Node<Integer> f2 = new Node<>(25);
    Node<Integer> g2 = new Node<>(65);
    Node<Integer> h2 = new Node<>(20);
    Node<Integer> i2 = new Node<>(35);
    Node<Integer> j2 = new Node<>(44);
    Node<Integer> k2 = new Node<>(9);
    //             (2)
    //            /   \
    //         (0)     (8)
    //        /  \     /  \
    //      (1)  (5) (20) (35)
    //          /   \     /  \
    //        (25) (65) (44) (9)
    a2.left = b2;
    a2.right = c2;
    b2.left = d2;
    b2.right = e2;
    e2.left = f2;
    e2.right = g2;
    c2.left = h2;
    c2.right = i2;
    i2.left = j2;
    i2.right = k2;
    treeB.root = a2;
    ArrayList<Integer> testList = sut.tree_intersection(treeA, treeB);
    Collections.sort(testList);
    assertEquals(testList.toString(), "[]");
  }

  @Test
  void negative_value_matches() {

    TreeIntersection sut = new TreeIntersection();
    BinaryTree<Integer> treeA = new BinaryTree<>();
    Node<Integer> a1 = new Node<>(-150);
    Node<Integer> b1 = new Node<>(-100);
    Node<Integer> c1 = new Node<>(-250);
    Node<Integer> d1 = new Node<>(-75);
    Node<Integer> e1 = new Node<>(-160);
    Node<Integer> f1 = new Node<>(-125);
    Node<Integer> g1 = new Node<>(-175);
    Node<Integer> h1 = new Node<>(-200);
    Node<Integer> i1 = new Node<>(-350);
    Node<Integer> j1 = new Node<>(-300);
    Node<Integer> k1 = new Node<>(-500);
    //              (150)
    //             /     \
    //         (100)     (250)
    //         /   \     /   \
    //      (75) (160) (200) (350)
    //           /   \       /    \
    //        (125) (175)  (300) (500)
    a1.left = b1;
    a1.right = c1;
    b1.left = d1;
    b1.right = e1;
    e1.left = f1;
    e1.right = g1;
    c1.left = h1;
    c1.right = i1;
    i1.left = j1;
    i1.right = k1;
    treeA.root = a1;

    BinaryTree<Integer> treeB = new BinaryTree<>();
    Node<Integer> a2 = new Node<>(-42);
    Node<Integer> b2 = new Node<>(-100);
    Node<Integer> c2 = new Node<>(-600);
    Node<Integer> d2 = new Node<>(-15);
    Node<Integer> e2 = new Node<>(-160);
    Node<Integer> f2 = new Node<>(-125);
    Node<Integer> g2 = new Node<>(-175);
    Node<Integer> h2 = new Node<>(-200);
    Node<Integer> i2 = new Node<>(-350);
    Node<Integer> j2 = new Node<>(-4);
    Node<Integer> k2 = new Node<>(-500);
    //              (42)
    //             /     \
    //         (100)     (600)
    //         /   \     /   \
    //      (15) (160) (200) (350)
    //           /   \       /    \
    //        (125) (175)  (4) (500)
    a2.left = b2;
    a2.right = c2;
    b2.left = d2;
    b2.right = e2;
    e2.left = f2;
    e2.right = g2;
    c2.left = h2;
    c2.right = i2;
    i2.left = j2;
    i2.right = k2;
    treeB.root = a2;
    ArrayList<Integer> testList = sut.tree_intersection(treeA, treeB);
    testList.sort(Collections.reverseOrder());
    assertEquals(testList.toString(), "[-100, -125, -160, -175, -200, -350, -500]");
  }

}
