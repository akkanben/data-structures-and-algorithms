package datastructures.tree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BinarySearchTreeTest {

  @Test
  void test_add() {
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

    System.out.println(Arrays.toString(sut.preOrderTraversal()));
    System.out.println(Arrays.toString(sut.inOrderTraversal()));
    System.out.println(Arrays.toString(sut.postOrderTraversal()));
    System.out.println(Arrays.toString(sut.breadthFirstTraversal()));
    System.out.println(sut.contains(5));
    System.out.println(sut.contains(3));
    System.out.println(sut.contains(2));
    System.out.println(sut.contains(4));
    System.out.println(sut.contains(8));
    System.out.println(sut.contains(9));
    System.out.println(sut.contains(7));
    System.out.println(sut.contains(10));
    System.out.println(sut.contains(-1));
    System.out.println(sut.contains(-100));
    System.out.println(sut.contains(30));
  }
}
