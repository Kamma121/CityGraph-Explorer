package graph;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void graphCreationWith5Vertices() {
        Graph graph = new Graph(5);
        assertNotNull(graph);
        assertEquals(5, graph.getNumVertices());
        assertNotNull(graph.adjacencyList);
    }

    @Test
    void addEdge() {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 10);
        assertEquals(10, graph.adjacencyList.get(0).get(0).getWeight());
        assertEquals(1, graph.adjacencyList.get(0).get(0).getTargetVertex());
        assertEquals(0, graph.adjacencyList.get(1).get(0).getTargetVertex());
        assertEquals(10, graph.adjacencyList.get(1).get(0).getWeight());
    }

    @Test
    void dijkstra() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 4);
        graph.addEdge(1, 4, 2);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 5, 2);
        graph.addEdge(4, 3, 3);
        graph.addEdge(4, 5, 2);
        List<Integer> path = graph.dijkstra(0, 5);
        assertNotNull(path);
        assertEquals(Arrays.asList(0, 1, 4, 5), path);
    }

    @Test
    void dijkstraWithEqualDistances() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 1);
        List<Integer> shortestPath = graph.dijkstra(0, 3);
        assertTrue(shortestPath.equals(Arrays.asList(0, 2, 3)) || shortestPath.equals(Arrays.asList(0, 1, 3)));
    }
}