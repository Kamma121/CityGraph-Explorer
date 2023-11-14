package graph;

import java.util.*;

public class Graph {
    public int numVertices;
    public Map<Integer, List<Edge>> adjacencyList;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new HashMap<>();

        for (int i = 0; i < numVertices; i++) {
            adjacencyList.put(i, new LinkedList<>());
        }
    }
    public void addEdge(int source,int target, int weight) {
        Edge edge = new Edge(target,weight);
        this.adjacencyList.get(source).add(edge);
        Edge reverseEdge = new Edge(source, weight);
        this.adjacencyList.get(target).add(reverseEdge);
    }
    public void dijkstra(int source, int target) {}
}
