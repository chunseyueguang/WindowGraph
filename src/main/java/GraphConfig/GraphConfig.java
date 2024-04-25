package GraphConfig;

import java.util.List;

public class GraphConfig {
    private List<VertexConfig> vertices;
    private List<EdgeConfig> edges;

    // Getters and Setters
    public List<VertexConfig> getVertices() {
        return vertices;
    }

    public void setVertices(List<VertexConfig> vertices) {
        this.vertices = vertices;
    }

    public List<EdgeConfig> getEdges() {
        return edges;
    }

    public void setEdges(List<EdgeConfig> edges) {
        this.edges = edges;
    }
}