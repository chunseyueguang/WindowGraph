package Graph;

import Graph.ConnectionType.ConnectionType;

public class Edge {
    public Vertex source, destination; // 源节点 目标节点
    public ConnectionType connectionType;

    public Edge() {
    }
    public Edge(Vertex source, Vertex destination) {
        this.source = source;
        this.destination = destination;
    }

    public Edge(Vertex source, Vertex destination, ConnectionType connectionType) {
        this.source = source;
        this.destination = destination;
        this.connectionType = connectionType;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getDestination(){

        return destination;
    }

    public ConnectionType getConnectionType() {
        return connectionType;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "u=" + source +
                ", v=" + destination +
                ", connectionType=" + connectionType +
                '}';
    }
}
