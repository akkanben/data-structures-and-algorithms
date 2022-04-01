package datastructures.graph;

import datastructures.hashtable.HashMap;
import datastructures.linkedlist.LinkedList;

import java.util.List;

public class Graph<T extends Comparable<? super T>> implements Comparable<Graph<T>> {
  private HashMap<Vertex<T>, LinkedList<Edge<T>>> adjacencyLists;
  private int size = 0;

  public Graph() {
    adjacencyLists = new HashMap<>();
  }

  public Graph(int size) {
    adjacencyLists = new HashMap<>(size);
  }

  public Vertex<T> addVertex(T value) {
    return null;
  }

  public void addEdge(Vertex<T> v1, Vertex<T> v2, int weight) {

  }

  public void addEdge(Vertex<T> v1, Vertex<T> v2) {
    addEdge(v1, v2, 0);
  }

  public List<Vertex<T>> getVertices() {
    return null;
  }

  public List<Edge<T>> getEdges() {
    return null;
  }

  public int size() {
    return size;
  }

  @Override
  public String toString() {
    return "";
  }

  @Override
  public int compareTo(Graph<T> o) {
    return 0;
  }
}
