package codechallenges;

import datastructures.graph.Graph;
import datastructures.graph.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BusinessTripTest {
  @Test
  void example_one() {
    GraphChallenges sut = new GraphChallenges();
    Graph<String> graph = new Graph<>();
    Vertex<String> pandora = graph.addVertex("Pandora");
    Vertex<String> arendelle = graph.addVertex("Arendelle");
    Vertex<String> metroville = graph.addVertex("Metroville");
    Vertex<String> monstropolis = graph.addVertex("Monstropolis");
    Vertex<String> narnia = graph.addVertex("Narnia");
    Vertex<String> naboo = graph.addVertex("Naboo");
    graph.addEdge(pandora, arendelle, 150);
    graph.addEdge(arendelle, pandora, 150);
    graph.addEdge(pandora, metroville, 82);
    graph.addEdge(metroville, pandora, 82);
    graph.addEdge(arendelle, metroville, 99);
    graph.addEdge(metroville, arendelle, 99);
    graph.addEdge(arendelle, monstropolis, 42);
    graph.addEdge(monstropolis, arendelle, 42);
    graph.addEdge(metroville, monstropolis, 105);
    graph.addEdge(monstropolis, metroville, 105);
    graph.addEdge(metroville, naboo, 26);
    graph.addEdge(naboo, metroville, 26);
    graph.addEdge(metroville, narnia, 37);
    graph.addEdge(narnia, metroville, 37);
    graph.addEdge(narnia, naboo, 250);
    graph.addEdge(naboo, narnia, 250);
    graph.addEdge(naboo, monstropolis, 73);
    graph.addEdge(monstropolis, naboo, 73);
    String[] cities = {"Metroville", "Pandora"};
    assertEquals(82, sut.businessTrip(graph, cities));
  }

  @Test
  void example_two() {
    GraphChallenges sut = new GraphChallenges();
    Graph<String> graph = new Graph<>();
    Vertex<String> pandora = graph.addVertex("Pandora");
    Vertex<String> arendelle = graph.addVertex("Arendelle");
    Vertex<String> metroville = graph.addVertex("Metroville");
    Vertex<String> monstropolis = graph.addVertex("Monstropolis");
    Vertex<String> narnia = graph.addVertex("Narnia");
    Vertex<String> naboo = graph.addVertex("Naboo");
    graph.addEdge(pandora, arendelle, 150);
    graph.addEdge(arendelle, pandora, 150);
    graph.addEdge(pandora, metroville, 82);
    graph.addEdge(metroville, pandora, 82);
    graph.addEdge(arendelle, metroville, 99);
    graph.addEdge(metroville, arendelle, 99);
    graph.addEdge(arendelle, monstropolis, 42);
    graph.addEdge(monstropolis, arendelle, 42);
    graph.addEdge(metroville, monstropolis, 105);
    graph.addEdge(monstropolis, metroville, 105);
    graph.addEdge(metroville, naboo, 26);
    graph.addEdge(naboo, metroville, 26);
    graph.addEdge(metroville, narnia, 37);
    graph.addEdge(narnia, metroville, 37);
    graph.addEdge(narnia, naboo, 250);
    graph.addEdge(naboo, narnia, 250);
    graph.addEdge(naboo, monstropolis, 73);
    graph.addEdge(monstropolis, naboo, 73);
    String[] cities = {"Arendelle", "Monstropolis", "Naboo"};
    assertEquals(115, sut.businessTrip(graph, cities));
  }

  @Test
  void example_three() {
    GraphChallenges sut = new GraphChallenges();
    Graph<String> graph = new Graph<>();
    Vertex<String> pandora = graph.addVertex("Pandora");
    Vertex<String> arendelle = graph.addVertex("Arendelle");
    Vertex<String> metroville = graph.addVertex("Metroville");
    Vertex<String> monstropolis = graph.addVertex("Monstropolis");
    Vertex<String> narnia = graph.addVertex("Narnia");
    Vertex<String> naboo = graph.addVertex("Naboo");
    graph.addEdge(pandora, arendelle, 150);
    graph.addEdge(arendelle, pandora, 150);
    graph.addEdge(pandora, metroville, 82);
    graph.addEdge(metroville, pandora, 82);
    graph.addEdge(arendelle, metroville, 99);
    graph.addEdge(metroville, arendelle, 99);
    graph.addEdge(arendelle, monstropolis, 42);
    graph.addEdge(monstropolis, arendelle, 42);
    graph.addEdge(metroville, monstropolis, 105);
    graph.addEdge(monstropolis, metroville, 105);
    graph.addEdge(metroville, naboo, 26);
    graph.addEdge(naboo, metroville, 26);
    graph.addEdge(metroville, narnia, 37);
    graph.addEdge(narnia, metroville, 37);
    graph.addEdge(narnia, naboo, 250);
    graph.addEdge(naboo, narnia, 250);
    graph.addEdge(naboo, monstropolis, 73);
    graph.addEdge(monstropolis, naboo, 73);
    String[] cities = {"Naboo", "Pandora"};
    assertEquals(0, sut.businessTrip(graph, cities));
  }

  @Test
  void example_four() {
    GraphChallenges sut = new GraphChallenges();
    Graph<String> graph = new Graph<>();
    Vertex<String> pandora = graph.addVertex("Pandora");
    Vertex<String> arendelle = graph.addVertex("Arendelle");
    Vertex<String> metroville = graph.addVertex("Metroville");
    Vertex<String> monstropolis = graph.addVertex("Monstropolis");
    Vertex<String> narnia = graph.addVertex("Narnia");
    Vertex<String> naboo = graph.addVertex("Naboo");
    graph.addEdge(pandora, arendelle, 150);
    graph.addEdge(arendelle, pandora, 150);
    graph.addEdge(pandora, metroville, 82);
    graph.addEdge(metroville, pandora, 82);
    graph.addEdge(arendelle, metroville, 99);
    graph.addEdge(metroville, arendelle, 99);
    graph.addEdge(arendelle, monstropolis, 42);
    graph.addEdge(monstropolis, arendelle, 42);
    graph.addEdge(metroville, monstropolis, 105);
    graph.addEdge(monstropolis, metroville, 105);
    graph.addEdge(metroville, naboo, 26);
    graph.addEdge(naboo, metroville, 26);
    graph.addEdge(metroville, narnia, 37);
    graph.addEdge(narnia, metroville, 37);
    graph.addEdge(narnia, naboo, 250);
    graph.addEdge(naboo, narnia, 250);
    graph.addEdge(naboo, monstropolis, 73);
    graph.addEdge(monstropolis, naboo, 73);
    String[] cities = {"Arendelle", "Naboo"};
    assertEquals(0, sut.businessTrip(graph, cities));
  }

  @Test
  void around_the_world() {
    GraphChallenges sut = new GraphChallenges();
    Graph<String> graph = new Graph<>();
    Vertex<String> pandora = graph.addVertex("Pandora");
    Vertex<String> arendelle = graph.addVertex("Arendelle");
    Vertex<String> metroville = graph.addVertex("Metroville");
    Vertex<String> monstropolis = graph.addVertex("Monstropolis");
    Vertex<String> narnia = graph.addVertex("Narnia");
    Vertex<String> naboo = graph.addVertex("Naboo");
    graph.addEdge(pandora, arendelle, 150);
    graph.addEdge(arendelle, pandora, 150);
    graph.addEdge(pandora, metroville, 82);
    graph.addEdge(metroville, pandora, 82);
    graph.addEdge(arendelle, metroville, 99);
    graph.addEdge(metroville, arendelle, 99);
    graph.addEdge(arendelle, monstropolis, 42);
    graph.addEdge(monstropolis, arendelle, 42);
    graph.addEdge(metroville, monstropolis, 105);
    graph.addEdge(monstropolis, metroville, 105);
    graph.addEdge(metroville, naboo, 26);
    graph.addEdge(naboo, metroville, 26);
    graph.addEdge(metroville, narnia, 37);
    graph.addEdge(narnia, metroville, 37);
    graph.addEdge(narnia, naboo, 250);
    graph.addEdge(naboo, narnia, 250);
    graph.addEdge(naboo, monstropolis, 73);
    graph.addEdge(monstropolis, naboo, 73);
    String[] cities = {"Pandora", "Arendelle", "Monstropolis", "Naboo", "Narnia", "Metroville", "Pandora"};
    assertEquals(634, sut.businessTrip(graph, cities));
  }

  @Test
  void too_few_vertices() {
    GraphChallenges sut = new GraphChallenges();
    Graph<String> graph = new Graph<>();
    Vertex<String> pandora = graph.addVertex("Pandora");
    String[] cities = {"Pandora", "Arendelle", "Monstropolis", "Naboo", "Narnia", "Metroville", "Pandora"};
    assertEquals(0, sut.businessTrip(graph, cities));
  }

  @Test
  void too_few_cities() {
    GraphChallenges sut = new GraphChallenges();
    Graph<String> graph = new Graph<>();
    Vertex<String> pandora = graph.addVertex("Pandora");
    Vertex<String> arendelle = graph.addVertex("Arendelle");
    Vertex<String> metroville = graph.addVertex("Metroville");
    Vertex<String> monstropolis = graph.addVertex("Monstropolis");
    Vertex<String> narnia = graph.addVertex("Narnia");
    Vertex<String> naboo = graph.addVertex("Naboo");
    graph.addEdge(pandora, arendelle, 150);
    graph.addEdge(arendelle, pandora, 150);
    graph.addEdge(pandora, metroville, 82);
    graph.addEdge(metroville, pandora, 82);
    graph.addEdge(arendelle, metroville, 99);
    graph.addEdge(metroville, arendelle, 99);
    graph.addEdge(arendelle, monstropolis, 42);
    graph.addEdge(monstropolis, arendelle, 42);
    graph.addEdge(metroville, monstropolis, 105);
    graph.addEdge(monstropolis, metroville, 105);
    graph.addEdge(metroville, naboo, 26);
    graph.addEdge(naboo, metroville, 26);
    graph.addEdge(metroville, narnia, 37);
    graph.addEdge(narnia, metroville, 37);
    graph.addEdge(narnia, naboo, 250);
    graph.addEdge(naboo, narnia, 250);
    graph.addEdge(naboo, monstropolis, 73);
    graph.addEdge(monstropolis, naboo, 73);
    String[] cities = {"Pandora"};
    assertEquals(0, sut.businessTrip(graph, cities));
  }


  @Test
  void empty_cities() {
    GraphChallenges sut = new GraphChallenges();
    Graph<String> graph = new Graph<>();
    Vertex<String> pandora = graph.addVertex("Pandora");
    Vertex<String> arendelle = graph.addVertex("Arendelle");
    Vertex<String> metroville = graph.addVertex("Metroville");
    Vertex<String> monstropolis = graph.addVertex("Monstropolis");
    Vertex<String> narnia = graph.addVertex("Narnia");
    Vertex<String> naboo = graph.addVertex("Naboo");
    graph.addEdge(pandora, arendelle, 150);
    graph.addEdge(arendelle, pandora, 150);
    graph.addEdge(pandora, metroville, 82);
    graph.addEdge(metroville, pandora, 82);
    graph.addEdge(arendelle, metroville, 99);
    graph.addEdge(metroville, arendelle, 99);
    graph.addEdge(arendelle, monstropolis, 42);
    graph.addEdge(monstropolis, arendelle, 42);
    graph.addEdge(metroville, monstropolis, 105);
    graph.addEdge(monstropolis, metroville, 105);
    graph.addEdge(metroville, naboo, 26);
    graph.addEdge(naboo, metroville, 26);
    graph.addEdge(metroville, narnia, 37);
    graph.addEdge(narnia, metroville, 37);
    graph.addEdge(narnia, naboo, 250);
    graph.addEdge(naboo, narnia, 250);
    graph.addEdge(naboo, monstropolis, 73);
    graph.addEdge(monstropolis, naboo, 73);
    String[] cities = new String[0];
    assertEquals(0, sut.businessTrip(graph, cities));
  }

  @Test
  void empty_graph() {
    GraphChallenges sut = new GraphChallenges();
    Graph<String> graph = new Graph<>();
    String[] cities = {"Nothing", "Potato", "Null", "Nope"};
    assertEquals(0, sut.businessTrip(graph, cities));
  }


}
