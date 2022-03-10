package codechallenges;

import com.sun.source.tree.Tree;
import datastructures.tree.KAryNode;
import datastructures.tree.KAryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class KAryTreeFizzBuzzTest {


  @Test
  void test_height_zero() {
    TreeChallenges sut = new TreeChallenges();
    KAryNode<Integer> a = new KAryNode<>(30);
    KAryNode<Integer> b = new KAryNode<>(9);
    KAryNode<Integer> c = new KAryNode<>(20);
    KAryNode<Integer> d = new KAryNode<>(1);
    a.addChild(b);
    a.addChild(c);
    a.addChild(d);
    //             (A)
    //            / | \
    //          (B)(C)(D)
    KAryTree<Integer> tree = new KAryTree<>();
    tree.root = a;
    assertEquals(sut.fizzBuzz(tree).toString(), "[FizzBuzz, Fizz, Buzz, 1]");
  }
  @Test
  void test_height_one() {
    TreeChallenges sut = new TreeChallenges();
    KAryNode<Integer> a = new KAryNode<>(7);
    KAryNode<Integer> b = new KAryNode<>(8);
    KAryNode<Integer> c = new KAryNode<>(9);
    KAryNode<Integer> d = new KAryNode<>(10);
    KAryNode<Integer> e = new KAryNode<>(15);
    a.addChild(b);
    a.addChild(c);
    a.addChild(d);
    c.addChild(e);
    //             (A)
    //            / | \
    //          (B)(C)(D)
    //              |
    //             (E)
    KAryTree<Integer> tree = new KAryTree<>();
    tree.root = a;
    assertEquals(sut.fizzBuzz(tree).toString(), "[7, 8, Fizz, FizzBuzz, Buzz]");
  }
  @Test
  void test_height_three_complex() {
    TreeChallenges sut = new TreeChallenges();
    KAryNode<Integer> a = new KAryNode<>(0);
    KAryNode<Integer> b = new KAryNode<>(50);
    KAryNode<Integer> c = new KAryNode<>(33);
    KAryNode<Integer> d = new KAryNode<>(60);
    KAryNode<Integer> e = new KAryNode<>(15);
    KAryNode<Integer> f = new KAryNode<>(-3);
    KAryNode<Integer> g = new KAryNode<>(3);
    KAryNode<Integer> h = new KAryNode<>(5);
    KAryNode<Integer> i = new KAryNode<>(4);
    KAryNode<Integer> j = new KAryNode<>(99);
    KAryNode<Integer> k = new KAryNode<>(7);
    a.addChild(b);
    a.addChild(c);
    a.addChild(d);
    b.addChild(e);
    b.addChild(f);
    e.addChild(g);
    e.addChild(h);
    d.addChild(i);
    d.addChild(j);
    d.addChild(k);
    //              (A)
    //            /  |  \
    //          (B) (C)  (D)
    //         /  \     / | \
    //       (E)  (F) (I)(J)(K)
    //      /  \
    //    (G)  (H)
    KAryTree<Integer> tree = new KAryTree<>();
    tree.root = a;
    // Tree equals [0, 50, 15, 3, 5, -3, 33, 60, 4, 99, 7]
    assertEquals(sut.fizzBuzz(tree).toString(), "[0, Buzz, FizzBuzz, Fizz, Buzz, -3, Fizz, FizzBuzz, 4, Fizz, 7]");
  }

  @Test
  void test_no_matches() {
    TreeChallenges sut = new TreeChallenges();
    KAryNode<Integer> a = new KAryNode<>(-100);
    KAryNode<Integer> b = new KAryNode<>(11);
    KAryNode<Integer> c = new KAryNode<>(98);
    KAryNode<Integer> d = new KAryNode<>(22);
    a.addChild(b);
    a.addChild(c);
    a.addChild(d);
    //             (A)
    //            / | \
    //          (B)(C)(D)
    KAryTree<Integer> tree = new KAryTree<>();
    tree.root = a;
    assertEquals(sut.fizzBuzz(tree).toString(), "[-100, 11, 98, 22]");
  }

  @Test
  void test_empty() {
    TreeChallenges sut = new TreeChallenges();
    KAryTree<Integer> tree = new KAryTree<>();
    assertThrows(IllegalArgumentException.class, () -> {
      sut.fizzBuzz(tree);
    });
  }
}
