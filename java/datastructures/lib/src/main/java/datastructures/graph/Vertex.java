package datastructures.graph;

import java.util.Objects;

public class Vertex<T extends Comparable<? super T>> implements Comparable<Vertex<T>> {

  public T value;

  public Vertex(T value) {
    this.value = value;
  }

  @Override
  public int compareTo(Vertex<T> o) {
    throw new UnsupportedOperationException("Vertex does not support compareTo()");
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Vertex<?> vertex = (Vertex<?>) obj;
    return Objects.equals(value, vertex.value);
  }
}
