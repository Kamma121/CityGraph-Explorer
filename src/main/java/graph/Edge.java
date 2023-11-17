package graph;

public class Edge {
    private final int targetVertex;
    private final int weight;

    public Edge(int targetVertex, int weight) {
        this.targetVertex = targetVertex;
        this.weight = weight;
    }

    public int getTargetVertex() {
        return targetVertex;
    }

    public int getWeight() {
        return weight;
    }
}
