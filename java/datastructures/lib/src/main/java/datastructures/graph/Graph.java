package datastructures.graph;

import datastructures.hashtable.HashMap;
import datastructures.linkedlist.LinkedList;
import datastructures.linkedlist.Node;
import datastructures.queue.Queue;
import datastructures.stack.Stack;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.HashSet;
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

  public ArrayList<Vertex<T>> getVertexListBreadthFirst(Vertex<T> start) {
    HashSet<T> set = new HashSet<>();
    ArrayList<Vertex<T>> output = new ArrayList<>();
    Queue<Vertex<T>> queue = new Queue<>();
    set.add(start.value);
    queue.enqueue(start);
    while (!queue.isEmpty()) {
      Vertex<T> current = queue.dequeue();
      output.add(current);
      for (Edge<T> edge : getNeighbors(current)) {
        if (!set.contains(edge.destination.value)) {
          queue.enqueue(edge.destination);
          set.add(edge.destination.value);
        }
      }
    }
    return output;
  }


  public ArrayList<Vertex<T>> getVertexListDepthFirst(Vertex<T> start) {
    HashSet<T> set = new HashSet<>();
    ArrayList<Vertex<T>> output = new ArrayList<>();
    Stack<Vertex<T>> stack = new Stack<>();
    set.add(start.value);
    stack.push(start);
    output.add(start);
    while (!stack.isEmpty()) {
      Vertex<T> current = stack.peek();
      Vertex<T> child = getFirstUnvisitedChild(current, set);
      if (child != null) {
        stack.push(child);
        set.add(child.value);
        output.add(child);
      } else
        stack.pop();
    }
    return output;
  }

  private Vertex<T> getFirstUnvisitedChild(Vertex<T> vertex, HashSet<T> set) {
    List<Edge<T>> list = getNeighbors(vertex);
    for (Edge<T> edge : list) {
      if (!set.contains(edge.destination.value))
        return edge.destination;
    }
    return null;
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
