package datastructures.graph;

public class Vertex<T extends Comparable<? super T>> implements Comparable<Vertex<T>> {

  private T value;

  public Vertex(T value) {
    this.value = value;
  }

  @Override
  public int compareTo(Vertex<T> o) {
    throw new UnsupportedOperationException("Vertex does not support compareTo()");
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }
}
