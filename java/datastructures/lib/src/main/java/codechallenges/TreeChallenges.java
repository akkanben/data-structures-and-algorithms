package codechallenges;

import datastructures.tree.Node;
import datastructures.queue.Queue;
import datastructures.tree.BinaryTree;

import java.util.ArrayList;

public class TreeChallenges {

  public ArrayList<Integer> breadthFirst(BinaryTree<Integer> tree) {
      ArrayList<Integer> list = new ArrayList<>();
      Queue<Node<Integer>> queue = new Queue<>();
      if (tree.root != null)
        queue.enqueue(tree.root);
      while(!queue.isEmpty()) {
        Node<Integer> temp = queue.dequeue();
        if (temp.left != null)
          queue.enqueue(temp.left);
        if (temp.right != null)
          queue.enqueue(temp.right);
        list.add( temp.value);
      }
      return list;
  }

}
