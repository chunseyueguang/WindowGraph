import Graph.Graph;
import Graph.Edge;
import Graph.Vertex;
import Utils.DrawingUtils;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GraphPanel extends JPanel {
    private Graph graph;

    public GraphPanel(Graph graph) {
        this.graph = graph;
        this.setPreferredSize(new Dimension(600, 600)); // 设置首选大小，确保足够的绘图空间
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGraph(g);
    }


    private void drawGraph(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // 设置绘制颜色
        g2d.setColor(Color.BLUE);

        Vertex firstV = graph.getVertexByName("Rectangle1");
        firstV.setX(300);
        firstV.setY(255);

        HashSet<Vertex> vertexDrawed = new HashSet<Vertex>();
        vertexDrawed.add(firstV);
        DrawingUtils.drawPolygon(g2d, firstV);


        Queue<Edge> vertexsToDraw = new LinkedList<>();    // 当前绘制的节点  连接 的节点

        List<Edge> firstV_Edges = graph.getAdjacencyList().get(firstV); // 获取当前顶点的所有边
        for (Edge edge : firstV_Edges) {// 遍历当前顶点的每条边
            vertexsToDraw.add(edge);
        }

        while(!vertexsToDraw.isEmpty()){
            Edge edgeToDetination = vertexsToDraw.poll();
            DrawingUtils.drawEdgeDestination(g2d, edgeToDetination, vertexDrawed);
            List<Edge> Edges = graph.getAdjacencyList().get(edgeToDetination.getDestination()); // 获取当前顶点的所有边
            for (Edge edge : Edges) {// 遍历当前顶点的每条边
                if(!vertexDrawed.contains(edge.getDestination()))
                    vertexsToDraw.add(edge);
            }
        }



    }

}