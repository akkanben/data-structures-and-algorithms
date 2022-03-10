package datastructures.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KAryTreeTest {

  @Test
  void test_constructor() {
    KAryNode<String> a = new KAryNode<>("hello");
    KAryTree<String> sut = new KAryTree<>();
    sut.root = a;
    assertEquals(sut.root.value, "hello");
  }

  @Test
  void test_addchild_single() {
    KAryNode<String> a = new KAryNode<>("root");
    KAryNode<String> b = new KAryNode<>("root child");
    KAryTree<String> sut = new KAryTree<>();
    a.addChild(b);
    sut.root = a;
    assertEquals(sut.root.childList.size(), 1);
    assertTrue(sut.root.childList.contains(b));
  }

  @Test
  void test_addchild_multiple() {
    KAryNode<String> a = new KAryNode<>("root");
    KAryNode<String> ba = new KAryNode<>("root child one");
    KAryNode<String> bb = new KAryNode<>("root child two");
    KAryNode<String> bc = new KAryNode<>("root child three");
    KAryNode<String> bd = new KAryNode<>("root child four");
    KAryNode<String> bba = new KAryNode<>("root child one's first child");
    KAryNode<String> bbb = new KAryNode<>("root child one's second child");
    a.addChild(ba);
    a.addChild(bb);
    a.addChild(bc);
    a.addChild(bd);
    bb.addChild(bba);
    bb.addChild(bbb);
    KAryTree<String> sut = new KAryTree<>();
    sut.root = a;
    assertEquals(sut.root.childList.size(), 4); // root's children count
    assertEquals(sut.root.childList.get(1).childList.size(), 2); // bb's children count
  }
}
