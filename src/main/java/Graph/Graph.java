package Graph;

import java.util.*;

public class Graph {
    private Map<Vertex, List<Edge>> adjacencyList;
    private Map<Vertex, List<Edge>> adjacencyListReverse;

    public Map<Vertex, List<Edge>> getAdjacencyList() {
        return adjacencyList;
    }

    public Graph() {
        this.adjacencyList = new HashMap<>();
        this.adjacencyListReverse = new HashMap<>();
    }

    // 添加顶点
    public void addVertex(Vertex vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
        adjacencyListReverse.putIfAbsent(vertex, new ArrayList<>());
    }

    // 添加边
    public void addEdge(Vertex source, Vertex destination, Edge edgeC) {
        adjacencyList.get(source).add(edgeC);
    }

    // 获取与顶点相连的所有边
    public List<Edge> getEdges(Vertex vertex) {
        return adjacencyList.get(vertex);
    }

    // 打印图
    public void printGraph() {
        for (Vertex v : adjacencyList.keySet()) {
            List<Edge> edgeCS = adjacencyList.get(v);
            System.out.print("Window.Graph.Vertex " + v.name + " is connected to: ");
            for (Edge e : edgeCS) {
                System.out.print(e.destination.name + " ");
            }
            System.out.println();
        }
    }
    // 获取邻接列表中的第一个节点
    public Vertex getFirstVertex() {
        // 返回邻接列表的第一个键
        return adjacencyList.isEmpty() ? null : adjacencyList.keySet().iterator().next();
    }

    // 获取所有顶点
    public Set<Vertex> getAllVertices() {
        return adjacencyList.keySet();
    }

    // 获取 指定的 vertex
    public Vertex getVertexByName(String name) {
        // 遍历所有顶点
        for (Vertex vertex : adjacencyList.keySet()) {
            if (vertex.getName().equals(name)) {
                return vertex; // 找到名为 name 的顶点并返回
            }
        }
        return null; // 如果没有找到，返回 null
    }

    // 获取除了第一个顶点以外的所有顶点
    public Set<Vertex> getAllVerticesExceptFirst() {
        Set<Vertex> allVertices = new HashSet<>(getAllVertices()); // 创建所有顶点的副本
        Vertex firstVertex = getFirstVertex(); // 获取第一个顶点
        if (firstVertex != null) {
            allVertices.remove(firstVertex); // 移除第一个顶点
        }
        return allVertices; // 返回修改后的顶点集
    }

    // 获取除了指定顶点外的所有顶点
    public Set<Vertex> getAllVerticesExcept(Vertex excludedVertex) {
        Set<Vertex> allVertices = new HashSet<>(getAllVertices()); // 创建所有顶点的副本
        if (excludedVertex != null) {
            allVertices.remove(excludedVertex); // 移除指定的顶点
        }
        return allVertices; // 返回修改后的顶点集
    }

}
