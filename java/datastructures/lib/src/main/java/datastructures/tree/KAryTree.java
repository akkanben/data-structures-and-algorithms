package datastructures.tree;

import datastructures.queue.Queue;

import java.util.ArrayList;

public class KAryTree<T extends Comparable<T>> {

  public KAryNode<T> root;

  public KAryTree() {
    //empty
  }

  public KAryTree(KAryNode<T> root) {
    this.root = root;
  }

  @Override
  public String toString() {
    ArrayList<String> list = new ArrayList<>();
    if (!root.childList.isEmpty())
      list.add(root.value.toString());
    buildPreOrderList(list, root);
    return list.toString();
  }

  private void buildPreOrderList(ArrayList<String> list, KAryNode<T> inputNode) {
    if (!inputNode.childList.isEmpty()) {
      for (KAryNode<T> node : inputNode.childList) {
        list.add(node.value.toString());
        buildPreOrderList(list, node);
      }
    }
  }
}
