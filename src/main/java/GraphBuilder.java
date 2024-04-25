import Graph.*;
import GraphConfig.*;
import Graph.ConnectionType.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GraphBuilder {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            GraphConfig graphConfig = mapper.readValue(new File("src/main/graph.json"), GraphConfig.class);
            Graph graph = new Graph();
            Map<String, Vertex> vertexMap = new HashMap<>();

            // 创建顶点
            for (VertexConfig vc : graphConfig.getVertices()) {
                Vertex v = new Vertex(vc.getName(), vc.getLength(), vc.getAngle(),
                        vc.getDirection() != null ? Vertex.trapeziumDirection.valueOf(vc.getDirection()) : null);
                graph.addVertex(v);
                vertexMap.put(vc.getName(), v);
            }

            // 创建边
            for (EdgeConfig ec : graphConfig.getEdges()) {
                Vertex fromVertex = vertexMap.get(ec.getFrom());
                Vertex toVertex = vertexMap.get(ec.getTo());


                Integer offset = ec.getConnectionType().getOffset();
                ConnectionType connectionType;
                if (offset != null) {
                    // 使用四参数构造函数
                    if(ec.getConnectionType().getAngle() != -1){
                        connectionType = new ConnectionType(
                                ConnectionType.createConnectionType(ec.getConnectionType().getType(),ec.getConnectionType().getAngle()),
                                ConnectionType.CenterRelativePosition.valueOf(ec.getConnectionType().getPosition()),
                                offset
                        );
                    }else{
                        connectionType = new ConnectionType(
                                ConnectionType.createConnectionType(ec.getConnectionType().getType()),
                                ConnectionType.CenterRelativePosition.valueOf(ec.getConnectionType().getPosition()),
                                offset
                        );
                    }

                } else {
                    // 使用三参数构造函数
                    connectionType = new ConnectionType(
                            ConnectionType.createConnectionType(ec.getConnectionType().getType()),
                            ConnectionType.CenterRelativePosition.valueOf(ec.getConnectionType().getPosition())
                    );
                }

                graph.addEdge(fromVertex, toVertex, new Edge(fromVertex, toVertex, connectionType));
            }


            // 打印图来验证连接
            graph.printGraph();

            JFrame frame = new JFrame("Window.Graph.Graph Drawing");
            GraphPanel panel = new GraphPanel(graph);




            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口关闭行为，当窗口关闭时退出整个程序
            frame.getContentPane().add(panel); // 将GraphPanel添加到JFrame的内容面板中
            frame.setLocationRelativeTo(null); // 将窗口置于屏幕中央
            frame.pack(); // 自动调整窗口大小以适应内容的首选大小和布局
            frame.setSize(600, 600); // 设置窗口的大小为600x600像素

            frame.setVisible(true); // 使窗口可见


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}