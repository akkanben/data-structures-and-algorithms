package datastructures.graph;

public class Edge<T extends Comparable<? super T>> implements Comparable<Vertex<T>> {

  public Vertex<T> destination;
  public int weight = 0;

  public Edge(Vertex<T> destination) {
    this.destination = destination;
  }

  public Edge(Vertex<T> destination, int weight) {
    this.destination = destination;
    this.weight = weight;
  }

  @Override
  public int compareTo(Vertex<T> o) {
    throw new UnsupportedOperationException("Edge does not support compareTo()");
  }



}
