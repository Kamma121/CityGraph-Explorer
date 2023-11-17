package graph;

public class Edge {
    private int targetVertex;
    private int weight;

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
