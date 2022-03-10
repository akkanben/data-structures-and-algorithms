package datastructures.tree;

import java.util.ArrayList;

public class KAryNode<T> {

  public T value;
  public ArrayList<KAryNode<T>> childList;

  public KAryNode() {
    childList = new ArrayList<>();
    //empty
  }

  public KAryNode(T value) {
    childList = new ArrayList<>();
    this.value = value;
  }

  public void addChild(KAryNode<T> child) {
    childList.add(child);
  }

}
