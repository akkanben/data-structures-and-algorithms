package datastructures.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {
  @Test
  void add_vertex() {
    Graph<String> sut = new Graph<>();
    sut.addVertex("Seattle");
    String testString = sut.getVertices().get(0).value;
    assertEquals(testString, "Seattle");
  }

  @Test
  void add_vertex_multiple() {
    Graph<Integer> sut = new Graph<>();
    Vertex<Integer> v1 = sut.addVertex(1000);
    Vertex<Integer> v2 = sut.addVertex(2000);
    Vertex<Integer> v3 = sut.addVertex(3000);
    Vertex<Integer> v4 = sut.addVertex(4000);
    Vertex<Integer> v5 = sut.addVertex(5000);
    Vertex<Integer> v6 = sut.addVertex(6000);
    Vertex<Integer> v7 = sut.addVertex(7000);
    Vertex<Integer> v8 = sut.addVertex(8000);
    Vertex<Integer> v9 = sut.addVertex(9000);
    Vertex<Integer> v10 = sut.addVertex(10000);
    Vertex<Integer> v11 = sut.addVertex(11000);
    assertEquals(sut.toString(), "" +
      "[1000] = {} -> NULL\n" +
      "[2000] = {} -> NULL\n" +
      "[3000] = {} -> NULL\n" +
      "[4000] = {} -> NULL\n" +
      "[5000] = {} -> NULL\n" +
      "[6000] = {} -> NULL\n" +
      "[7000] = {} -> NULL\n" +
      "[8000] = {} -> NULL\n" +
      "[9000] = {} -> NULL\n" +
      "[10000] = {} -> NULL\n" +
      "[11000] = {} -> NULL");
  }


  @Test
  void add_edge() {
    Graph<Double> sut = new Graph<>();
    Vertex<Double> v1 = sut.addVertex(10.75);
    Vertex<Double> v2 = sut.addVertex(20.25);
    sut.addEdge(v1, v2);
    sut.addEdge(v2, v1);
    assertEquals(sut.toString(), "" +
      "[20.25] = {10.75:0} -> NULL\n" +
      "[10.75] = {20.25:0} -> NULL");
  }

  @Test
  void add_edge_with_weight() {
    Graph<Double> sut = new Graph<>();
    Vertex<Double> v1 = sut.addVertex(10.75);
    Vertex<Double> v2 = sut.addVertex(20.25);
    sut.addEdge(v1, v2, 5);
    sut.addEdge(v2, v1, 4);
    assertEquals(sut.toString(), "" +
      "[20.25] = {10.75:4} -> NULL\n" +
      "[10.75] = {20.25:5} -> NULL");
  }

  @Test
  void add_edge_multiple() {
    Graph<Integer> sut = new Graph<>();
    Vertex<Integer> v1 = sut.addVertex(100);
    Vertex<Integer> v2 = sut.addVertex(200);
    Vertex<Integer> v3 = sut.addVertex(300);
    Vertex<Integer> v4 = sut.addVertex(400);

    sut.addEdge(v1, v2);
    sut.addEdge(v1, v3);
    sut.addEdge(v1, v4);
    sut.addEdge(v2, v1);
    sut.addEdge(v3, v1);
    assertEquals(sut.toString(), "" +
      "[100] = {200:0} -> {300:0} -> {400:0} -> NULL\n" +
      "[200] = {100:0} -> NULL\n" +
      "[300] = {100:0} -> NULL\n" +
      "[400] = {} -> NULL");
  }

  @Test
  void add_edge_multiple_with_weight() {
    Graph<Integer> sut = new Graph<>();
    Vertex<Integer> v1 = sut.addVertex(100);
    Vertex<Integer> v2 = sut.addVertex(200);
    Vertex<Integer> v3 = sut.addVertex(300);
    Vertex<Integer> v4 = sut.addVertex(400);

    sut.addEdge(v1, v2, 1);
    sut.addEdge(v1, v3, 1);
    sut.addEdge(v1, v4, 2);
    sut.addEdge(v2, v1, 0);
    sut.addEdge(v3, v1, 2);
    assertEquals(sut.toString(), "" +
      "[100] = {200:1} -> {300:1} -> {400:2} -> NULL\n" +
      "[200] = {100:0} -> NULL\n" +
      "[300] = {100:2} -> NULL\n" +
      "[400] = {} -> NULL");
  }

  @Test
  void size() {
    Graph<String> sut = new Graph<>();
    sut.addVertex("Seattle");
    sut.addVertex("Chicago");
    sut.addVertex("San Fransisco");
    sut.addVertex("New York");
    assertEquals(sut.size(), 4);
  }

  @Test
  void null_test() {
    Graph<String> sut = new Graph<>();
    assertEquals(sut.toString(), "");
  }
}