package graph;

import java.util.*;

public class Graph {
    private final int numVertices;

    public final Map<Integer, List<Edge>> adjacencyList;

    public int getNumVertices() {
        return numVertices;
    }

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new HashMap<>();

        for (int i = 0; i < numVertices; i++) {
            adjacencyList.put(i, new LinkedList<>());
        }
    }

    public void addEdge(int source, int target, int weight) {
        Edge edge = new Edge(target, weight);
        this.adjacencyList.get(source).add(edge);
        Edge reverseEdge = new Edge(source, weight);
        this.adjacencyList.get(target).add(reverseEdge);
    }

    public List<Integer> dijkstra(int source, int target) {
        int[] distances = new int[this.numVertices];
        boolean[] visited = new boolean[this.numVertices];
        int[] parents = new int[this.numVertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(v -> distances[v]));
        queue.add(source);
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            if (currentVertex == target) {
                return reconstructPath(source, target, parents);
            }
            if (!visited[currentVertex]) {
                visited[currentVertex] = true;
                List<Edge> neighbors = this.adjacencyList.get(currentVertex);
                for (Edge edge : neighbors) {
                    int neighbor = edge.getTargetVertex();
                    int currentDistance = distances[currentVertex] + edge.getWeight();
                    if (currentDistance < distances[neighbor]) {
                        distances[neighbor] = currentDistance;
                        parents[neighbor] = currentVertex;
                        queue.add(neighbor);
                    }
                }
            }
        }
        return null;
    }

    private List<Integer> reconstructPath(int source, int target, int[] parents) {
        List<Integer> path = new ArrayList<>();
        int currentVertex = target;
        while (currentVertex != source) {
            path.add(currentVertex);
            currentVertex = parents[currentVertex];
        }
        path.add(source);
        Collections.reverse(path);
        return path;
    }
}


