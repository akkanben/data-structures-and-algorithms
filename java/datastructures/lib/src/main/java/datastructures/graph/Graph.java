package datastructures.graph;

import datastructures.hashtable.HashMap;
import datastructures.linkedlist.LinkedList;
import datastructures.linkedlist.Node;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class Graph<T extends Comparable<? super T>> implements Comparable<Graph<T>> {
  private final HashMap<Vertex<T>, LinkedList<Edge<T>>> adjacencyLists;
  private int size = 0;

  public Graph() {
    adjacencyLists = new HashMap<>();
  }

  public Graph(int size) {
    adjacencyLists = new HashMap<>(size);
  }

  public Vertex<T> addVertex(T value) {
    Vertex<T> newVertex = new Vertex<>(value);
    if (adjacencyLists.get(newVertex) == null) {
      adjacencyLists.set(newVertex, null);
      size++;
    }
    return newVertex;
  }

  public void addEdge(Vertex<T> v1, Vertex<T> v2, int weight) {
    Edge<T> newEdge = new Edge<>(v2, weight);
    if (adjacencyLists.get(v1) == null) {
      LinkedList<Edge<T>> newLinkedList = new LinkedList<>();
      newLinkedList.append(newEdge);
      adjacencyLists.set(v1, newLinkedList);
    } else {
      LinkedList<Edge<T>> existingLinkedList = adjacencyLists.get(v1);
      existingLinkedList.append(newEdge);
      adjacencyLists.set(v1, existingLinkedList);
    }
  }

  public void addEdge(Vertex<T> v1, Vertex<T> v2) {
    addEdge(v1, v2, 0);
  }

  public List<Vertex<T>> getVertices() {
    List<Vertex<T>> list = new ArrayList<>();
    for (Vertex<T> vertex : adjacencyLists.keys()) {
      list.add(vertex);
    }
    return list;
  }

  public List<Edge<T>> getNeighbors(Vertex<T> vertex) {
    List<Edge<T>> list = new ArrayList<>();
    LinkedList<Edge<T>> edgeLinkedList = adjacencyLists.get(vertex);
    if (edgeLinkedList != null) {
      Node<Edge<T>> current;
      current = edgeLinkedList.head;
      while (current != null) {
        list.add(current.value);
        current = current.next;
      }
    }
    return list;
  }

  public int size() {
    return size;
  }

  @Override
  public String toString() {
    String output = "";
    for (Vertex<T> vertex : adjacencyLists.keys()) {
      output += "[" + vertex.value.toString() + "] = ";
      for (Edge<T> edge : getNeighbors(vertex)) {
        output += "{" + edge.destination.value
          .toString() + ":" + edge.weight + "} -> ";
      }
      if (output.substring(output.length() - 2).equals("= "))
        output += "{} -> ";
      output += "NULL\n";
    }
    if (output.length() < 1)
      return "";
    else
      return output.substring(0, output.length() - 1);
  }

  @Override
  public int compareTo(Graph<T> o) {
    throw new UnsupportedOperationException("Graph does not support compareTo()");
  }
}