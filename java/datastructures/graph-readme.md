# Graphs

## Challenge

Implement a Graph class using an adjacency list.

### Requirements

- An add node method that adds a vertex to the graph and also returns that vertex.
- An add edge method that creates an edge between two vertices with an optional weight.
- A method to return a collection of all vertices. 
- A method to return a vertex's neighbors in the form of a collection of edges with weights.
- A method to return number of vertices in the graph.

### Tests

1. Node can be successfully added to the graph
2. An edge can be successfully added to the graph
3. A collection of all nodes can be properly retrieved from the graph
4. All appropriate neighbors can be retrieved from the graph
5. Neighbors are returned with the weight between nodes included
6. The proper size is returned, representing the number of nodes in the graph
7. A graph with only one node and edge can be properly returned
8. An empty graph properly returns null

## Approach & Efficiency

The build the implementation of a graph using an adjacency list I used a hashmap. The vertices are the keys and the value for each key is a linked list of edges. Each edge has a destination and a weight (or 0 if none is supplied).

For adding nodes and edges the time complexity is O(N) in the worst case or all the vertices hashing to the same value and all of the vertices being connected to each other. Adding nodes and edges doesn't use any extra space. For retrieving the collection of nodes or retrieving the collection of edges the time complexity is O(N) because we need to visit each element. The space uses is also O(N) because the collection will contain all the elements.

## API

### Graph

**public Graph()** Instantiates a graph with an empty adjacency list.

**public Graph(int size)** Instantiates a graph with a specified size.

**public Vertex<T> addVertex(T value)** Adds a vertex to the graph with the specified value.

**public void addEdge(Vertex<T> v1, Vertex<T> v2, int weight)** Adds a directed edge from v1 to v2 with a specified weight.

**public void addEdge(Vertex<T> v1, Vertex<T> v2)** Adds a directed edge from v1 to v2 with the weight of 0.

**public List<Vertex<T>> getVertices()** Returns a list of vertices.

**public List<Edge<T>> getNeighbors(Vertex<T> vertex)** Returns a list of all the edges of a specified vertex.

**public int size()** Returns the number of vertices in the graph.
