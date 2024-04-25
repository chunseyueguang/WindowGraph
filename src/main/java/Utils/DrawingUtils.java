package Utils;


import Graph.ConnectionType.ConnType.EndConnectionObliqueEdge;
import Graph.ConnectionType.ConnType.EndConnectionStraightEdge;
import Graph.ConnectionType.ConnType.FullConnection;
import Graph.ConnectionType.ConnType.MidConnection;
import Graph.Edge;
import Graph.Vertex;

import java.awt.*;
import java.util.HashSet;

public class DrawingUtils {

    public static void drawPolygon(Graphics2D g2d,Vertex vertex){
        if(vertex.getDirection() == Vertex.trapeziumDirection.None){
            DrawingUtils.drawRotatedRectangle(g2d, vertex);
        } else {
            DrawingUtils.drawTrapezoid(g2d,vertex);
        }
    }
    public static void drawRotatedRectangle(Graphics2D g2d,Vertex vertex) {
        g2d.drawRect(vertex.getX() - vertex.getXDistance()/2, vertex.getY() - vertex.getYDistance()/2, vertex.getXDistance(), vertex.getYDistance());
    }

    public static void drawTrapezoid(Graphics2D g2d,Vertex vertex) { // 梯形 都以 45度角绘制
        int[] xPoints = new int[4];     // 定义梯形的四个顶点
        int[] yPoints = new int[4];
        int topLeftX = 0, topLeftY = 0, topRightX = 0, topRightY = 0, bottomLeftX = 0, bottomLeftY = 0, bottomRightX = 0, bottomRightY = 0;
        if(vertex.getDirection() == Vertex.trapeziumDirection.Down){    // 朝下
            topLeftX = vertex.getX() - vertex.getXDistance()/2;   // 左上角节点
            topLeftY = vertex.getY() - vertex.getYDistance()/2;

            topRightX = topLeftX + vertex.getXDistance();        // 右上角坐标
            topRightY = topLeftY;

            bottomLeftX = topLeftX + vertex.getShortSide();        // 左下角坐标
            bottomLeftY = topLeftY + vertex.getYDistance();

            bottomRightX = topRightX - vertex.getShortSide();        // 右下角坐标
            bottomRightY = bottomLeftY;

        } else if (vertex.getDirection() == Vertex.trapeziumDirection.Up) {     // 朝上
            bottomLeftX = vertex.getX() - vertex.getXDistance()/2;    // 左下角坐标
            bottomLeftY = vertex.getY() + vertex.getYDistance()/2;

            bottomRightX = bottomLeftX + vertex.getXDistance();        // 右下角坐标
            bottomRightY = bottomLeftY;

            topLeftX = bottomLeftX + vertex.getShortSide();        // 左上角节点
            topLeftY = bottomLeftY - vertex.getYDistance();

            topRightX = bottomRightX - vertex.getShortSide();        // 右上角坐标
            topRightY = topLeftY;
        } else if(vertex.getDirection() == Vertex.trapeziumDirection.Left){     // 朝左
            topRightX = vertex.getX() + vertex.getXDistance()/2;        // 右上角坐标
            topRightY = vertex.getY() - vertex.getYDistance()/2;

            bottomRightX = topRightX;        // 右下角坐标
            bottomRightY = topRightY + vertex.getYDistance();

            topLeftX = topRightX - vertex.getXDistance();        // 左上角节点
            topLeftY = topRightY + vertex.getShortSide();

            bottomLeftX = topLeftX;    // 左下角坐标
            bottomLeftY = bottomRightY - vertex.getShortSide();

        } else if (vertex.getDirection() == Vertex.trapeziumDirection.Right) {
            topLeftX = vertex.getX() - vertex.getXDistance()/2;        // 左上角节点
            topLeftY = vertex.getY() - vertex.getYDistance()/2;

            bottomLeftX = topLeftX;    // 左下角坐标
            bottomLeftY = topLeftY + vertex.getYDistance();

            topRightX = topLeftX + vertex.getXDistance();        // 右上角坐标
            topRightY = topLeftY + vertex.getShortSide();

            bottomRightX = topRightX;        // 右下角坐标
            bottomRightY = bottomLeftY - vertex.getShortSide();

        }

        xPoints[0] = topLeftX;
        xPoints[1] = bottomLeftX;
        xPoints[2] = bottomRightX;
        xPoints[3] = topRightX;

        yPoints[0] = topLeftY;
        yPoints[1] = bottomLeftY;
        yPoints[2] = bottomRightY;
        yPoints[3] = topRightY;

        // 遍历并输出梯形的四个顶点坐标
//        for (int i = 0; i < 4; i++) {
//            System.out.println("顶点" + i + "：(" + xPoints[i] + ", " + yPoints[i] + ")");
//        }
//        System.out.println(xPoints);
//        System.out.println(yPoints);
        // 创建并绘制多边形
        Polygon trapezoid = new Polygon(xPoints, yPoints, 4);
        g2d.drawPolygon(trapezoid);

    }

    public static void drawEdgeDestination(Graphics2D g2d, Edge edge, HashSet<Vertex> vertexDrawed) {
        Vertex source = edge.getSource();
        Vertex destination = edge.getDestination();
        if (!vertexDrawed.contains(destination)){
            if (edge.getConnectionType().getConnType() instanceof EndConnectionStraightEdge ) {

                ((EndConnectionStraightEdge) edge.getConnectionType().getConnType()).calculateDestinationNodeCenterCoordinate(
                        source,destination,
                        ((EndConnectionStraightEdge) edge.getConnectionType().getConnType()).getSourceSide(),
                        ((EndConnectionStraightEdge) edge.getConnectionType().getConnType()).getDestinationSide(),
                        edge.getConnectionType().getV2u()
                );
                DrawingUtils.drawRotatedRectangle(g2d, destination);

            }else if(edge.getConnectionType().getConnType() instanceof FullConnection){

                ((FullConnection) edge.getConnectionType().getConnType()).calculateDestinationNodeCenterCoordinate(
                        source,destination,
                    edge.getConnectionType().getV2u()
                );

                DrawingUtils.drawRotatedRectangle(g2d, destination);


            }else if(edge.getConnectionType().getConnType() instanceof MidConnection){

                ((MidConnection) edge.getConnectionType().getConnType()).calculateDestinationNodeCenterCoordinate(
                        source,destination,
                    edge.getConnectionType().getV2u(),
                    edge.getConnectionType().getDeviation()
                );

                DrawingUtils.drawRotatedRectangle(g2d, destination);

            }else if(edge.getConnectionType().getConnType() instanceof EndConnectionObliqueEdge){

                ((EndConnectionObliqueEdge) edge.getConnectionType().getConnType()).calculateDestinationNodeCenterCoordinate(
                        source,destination,
                        source.getDirection(),
                        edge.getConnectionType().getV2u()
                );
                DrawingUtils.drawPolygon(g2d, destination);

            }
        }
        vertexDrawed.add(destination);
    }

}
