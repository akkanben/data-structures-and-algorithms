package codechallenges;

import datastructures.tree.KAryNode;
import datastructures.tree.KAryTree;
import datastructures.tree.Node;
import datastructures.queue.Queue;
import datastructures.tree.BinaryTree;

import java.util.ArrayList;

public class TreeChallenges {

  // Code Challenge 17 Breadth First

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

  // Code Challenge 18 FizzBuzz K-Ary Tree (3 Functions)

  public KAryTree<String> fizzBuzz(KAryTree<Integer> tree) {
    if (tree.root == null)
      throw new IllegalArgumentException();
    KAryNode<String> outputRoot = new KAryNode<>();
    outputRoot.value = getFizzBuzzValue(tree.root.value);
    buildStringTree(outputRoot, tree.root);
    return new KAryTree<String>(outputRoot);
  }

  private void buildStringTree(KAryNode<String> outNode, KAryNode<Integer> inNode) {
    if (!inNode.childList.isEmpty()) {
      for (KAryNode<Integer> node : inNode.childList) {
        KAryNode<String> temp = new KAryNode<>();
        temp.value = getFizzBuzzValue(node.value);
        outNode.childList.add(temp);
        buildStringTree(temp, node);
      }
    }
  }

  private String getFizzBuzzValue(Integer inputValue) {
    if (inputValue < 3)
      return inputValue.toString();
    else if (inputValue % 3 == 0 && inputValue % 5 == 0)
      return "FizzBuzz";
    else if (inputValue % 3 == 0)
      return "Fizz";
    else if (inputValue % 5 == 0)
      return "Buzz";
    else
      return inputValue.toString();
    }
}
