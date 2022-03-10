package datastructures.tree;

public class KAryTree<T extends Comparable<T>> {

  public KAryNode<T> root;

  public KAryTree() {
    //empty
  }

  public KAryTree(KAryNode<T> root) {
    this.root = root;
  }

}
