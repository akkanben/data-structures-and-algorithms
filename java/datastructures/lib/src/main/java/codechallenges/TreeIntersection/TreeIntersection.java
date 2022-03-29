package codechallenges.TreeIntersection;

import datastructures.hashtable.HashMap;
import datastructures.tree.BinaryTree;
import datastructures.tree.Node;

import java.util.ArrayList;

public class TreeIntersection {
  public ArrayList<Integer> tree_intersection(BinaryTree<Integer> treeA, BinaryTree<Integer> treeB) {
    HashMap<Integer, Boolean> hashmapA = new HashMap<>();
    HashMap<Integer, Boolean> hashmapB = new HashMap<>();
    ArrayList<Integer> list = new ArrayList<>();
    preOrderAddToMap(treeA.root, hashmapA);
    preOrderAddToMap(treeB.root, hashmapB);
    for (Integer element : hashmapA.keys()) {
      if (hashmapB.contains(element))
        list.add(element);
    }
    return list;
  }

  private void preOrderAddToMap(Node<Integer> root, HashMap<Integer, Boolean> hashmap) {
    if (root == null)
      return;
    hashmap.set(root.value, true);
    preOrderAddToMap(root.left, hashmap);
    preOrderAddToMap(root.right, hashmap);
  }
}
