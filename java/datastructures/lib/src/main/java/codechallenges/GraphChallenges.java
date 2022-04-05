package codechallenges;

import datastructures.graph.Edge;
import datastructures.graph.Graph;
import datastructures.graph.Vertex;

import java.util.List;

public class GraphChallenges {

  public int businessTrip(Graph<String> graph, String[] cities) {
    int total = 0;
    Vertex<String> origin = new Vertex<>(cities[0]);
    List<Vertex<String>> vertices = graph.getVertices();
    for (Vertex<String> vertex : vertices) {
      if (vertex.value.equals(cities[0])) {
        origin = vertex;
        break;
      }
    }
    for (int i = 1; i < cities.length; i++) {
      boolean connects = false;
      for (Edge<String> edge : graph.getNeighbors(origin)) {
        if (edge.destination.value.equals(cities[i])) {
          total += edge.weight;
          origin = edge.destination;
          connects = true;
          break;
        }
      }
      if (!connects)
        return 0;
    }
    return total;
  }
}
