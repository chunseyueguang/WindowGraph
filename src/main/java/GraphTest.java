import Graph.ConnectionType.ConnType.EndConnectionObliqueEdge;
import Graph.ConnectionType.ConnType.EndConnectionStraightEdge;
import Graph.ConnectionType.ConnType.FullConnection;
import Graph.ConnectionType.ConnType.MidConnection;
import Graph.ConnectionType.ConnectionType;
import Graph.Graph;
import Graph.Vertex;
import Graph.Edge;

import javax.swing.*;


public class GraphTest {


    public static void main(String[] args) {


        // 创建图
        Graph graph = new Graph();

        // 创建顶点
        Vertex v1 = new Vertex("Rectangle1",200,0, Vertex.trapeziumDirection.Down);
        Vertex v2 = new Vertex("Rectangle2",200,Math.PI / 2,Vertex.trapeziumDirection.Left);
        Vertex v3 = new Vertex("Rectangle3",200,0,Vertex.trapeziumDirection.Up);
        Vertex v4 = new Vertex("Rectangle4",200,Math.PI / 2,Vertex.trapeziumDirection.Right);

        Vertex v5 = new Vertex("Rectangle5",180,0);
        Vertex v6 = new Vertex("Rectangle6",160,Math.PI / 2);
        Vertex v7 = new Vertex("Rectangle7",180,0);
        Vertex v8 = new Vertex("Rectangle8",160,Math.PI / 2);

        Vertex v9 = new Vertex("Rectangle9",160,Math.PI / 2);

        // 添加顶点到图中
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);

        graph.addVertex(v5);
        graph.addVertex(v6);
        graph.addVertex(v7);
        graph.addVertex(v8);

        graph.addVertex(v9);



        // 添加边
        graph.addEdge(v1, v2, new Edge(v1,v2,
                new ConnectionType(new EndConnectionObliqueEdge(),
                        ConnectionType.CenterRelativePosition.DownRight)));
        graph.addEdge(v2, v3, new Edge(v2,v3,
                new ConnectionType(new EndConnectionObliqueEdge(),
                        ConnectionType.CenterRelativePosition.DownLeft)));
        graph.addEdge(v3, v4, new Edge(v3,v4,
                new ConnectionType(new EndConnectionObliqueEdge(),
                        ConnectionType.CenterRelativePosition.UpLeft)));
        graph.addEdge(v4, v1, new Edge(v4,v1,
                new ConnectionType(new EndConnectionObliqueEdge(),
                        ConnectionType.CenterRelativePosition.UpRight)));

        graph.addEdge(v1, v5, new Edge(v1,v5,
                new ConnectionType(new FullConnection(),
                        ConnectionType.CenterRelativePosition.Down)));
        graph.addEdge(v2, v6, new Edge(v2,v6,
                new ConnectionType(new FullConnection(),
                        ConnectionType.CenterRelativePosition.Left)));
        graph.addEdge(v3, v7, new Edge(v3,v7,
                new ConnectionType(new FullConnection(),
                        ConnectionType.CenterRelativePosition.Up)));
        graph.addEdge(v4, v8, new Edge(v4,v8,
                new ConnectionType(new FullConnection(),
                        ConnectionType.CenterRelativePosition.Right)));


        graph.addEdge(v5, v6, new Edge(v5,v6,
                new ConnectionType(new EndConnectionStraightEdge(0),
                        ConnectionType.CenterRelativePosition.DownRight)));
        graph.addEdge(v6, v7, new Edge(v6,v7,
                new ConnectionType(new EndConnectionStraightEdge(0),
                        ConnectionType.CenterRelativePosition.DownLeft)));
        graph.addEdge(v7, v8, new Edge(v7,v8,
                new ConnectionType(new EndConnectionStraightEdge(Math.PI),
                        ConnectionType.CenterRelativePosition.UpLeft)));
        graph.addEdge(v8, v5, new Edge(v8,v5,
                new ConnectionType(new EndConnectionStraightEdge(Math.PI),
                        ConnectionType.CenterRelativePosition.UpRight)));




        graph.addEdge(v5, v9, new Edge(v5,v9,
                new ConnectionType(new MidConnection(),
                        ConnectionType.CenterRelativePosition.Down,
                        -10)));
        graph.addEdge(v7, v9, new Edge(v7,v9,
                new ConnectionType(
                        new MidConnection(), ConnectionType.CenterRelativePosition.Up, -10)
                )
        );


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

    }




//    public static void main(String[] args) {
//        // 创建图
//        Graph graph = new Graph();
//
//        // 创建顶点
////        Window.Graph.Vertex v1 = new Window.Graph.Vertex("Rectangle1",80,0);
////        Window.Graph.Vertex v2 = new Window.Graph.Vertex("Rectangle2",100,Math.PI / 2);
////        Window.Graph.Vertex v3 = new Window.Graph.Vertex("Rectangle3",80,0);
////        Window.Graph.Vertex v4 = new Window.Graph.Vertex("Rectangle4",100,Math.PI / 2);
////
////        // 添加顶点到图中
////        graph.addVertex(v3);
////        graph.addVertex(v2);
////        graph.addVertex(v1);
////        graph.addVertex(v4);
////
////
////
////        // 添加边
////        graph.addEdge(v1, v2, new Window.Graph.Graph.Edge(v1,v2,
////                new Window.Graph.ConnectionType.ConnectionType(Window.Graph.ConnectionType.ConnectionType.ConnType.EndConnection_StraightEdge,
////                        Window.Graph.ConnectionType.ConnectionType.ConnectionSide.Right,
////                        Window.Graph.ConnectionType.ConnectionType.ConnectionSide.Left,
////                        Window.Graph.ConnectionType.ConnectionType.CenterRelativePosition.DownRight)));
////        graph.addEdge(v2, v3, new Window.Graph.Graph.Edge(v2,v3,
////                new Window.Graph.ConnectionType.ConnectionType(Window.Graph.ConnectionType.ConnectionType.ConnType.EndConnection_StraightEdge,
////                        Window.Graph.ConnectionType.ConnectionType.ConnectionSide.Left,
////                        Window.Graph.ConnectionType.ConnectionType.ConnectionSide.Right,
////                        Window.Graph.ConnectionType.ConnectionType.CenterRelativePosition.DownLeft)));
////        graph.addEdge(v3, v4, new Window.Graph.Graph.Edge(v3,v4,
////                new Window.Graph.ConnectionType.ConnectionType(Window.Graph.ConnectionType.ConnectionType.ConnType.EndConnection_StraightEdge,
////                        Window.Graph.ConnectionType.ConnectionType.ConnectionSide.Left,
////                        Window.Graph.ConnectionType.ConnectionType.ConnectionSide.Right,
////                        Window.Graph.ConnectionType.ConnectionType.CenterRelativePosition.UpLeft)));
////        graph.addEdge(v4, v1, new Window.Graph.Graph.Edge(v4,v1,
////                new Window.Graph.ConnectionType.ConnectionType(Window.Graph.ConnectionType.ConnectionType.ConnType.EndConnection_StraightEdge,
////                        Window.Graph.ConnectionType.ConnectionType.ConnectionSide.Right,
////                        Window.Graph.ConnectionType.ConnectionType.ConnectionSide.Left,
////                        Window.Graph.ConnectionType.ConnectionType.CenterRelativePosition.UpRight)));
//
////        // 创建顶点
//        Vertex v1 = new Vertex("Rectangle1",200,0);
//        Vertex v2 = new Vertex("Rectangle2",180,Math.PI / 2);
//        Vertex v3 = new Vertex("Rectangle3",200,0);
//        Vertex v4 = new Vertex("Rectangle4",180,Math.PI / 2);
//
//        Vertex v5 = new Vertex("Rectangle5",180,0);
//        Vertex v6 = new Vertex("Rectangle6",160,Math.PI / 2);
//        Vertex v7 = new Vertex("Rectangle7",180,0);
//        Vertex v8 = new Vertex("Rectangle8",160,Math.PI / 2);
//
//        Vertex v9 = new Vertex("Rectangle9",160,Math.PI / 2);
//
//        // 添加顶点到图中
//        graph.addVertex(v1);
//        graph.addVertex(v2);
//        graph.addVertex(v3);
//        graph.addVertex(v4);
//
//        graph.addVertex(v5);
//        graph.addVertex(v6);
//        graph.addVertex(v7);
//        graph.addVertex(v8);
//
//        graph.addVertex(v9);
//
//
//
//        // 添加边
//        graph.addEdge(v1, v2, new Edge(v1,v2,
//                        new ConnectionType(ConnectionType.ConnType.EndConnection_StraightEdge,
//                                ConnectionType.ConnectionSide.Down,
//                                ConnectionType.ConnectionSide.Up,
//                                ConnectionType.CenterRelativePosition.DownRight)));
//        graph.addEdge(v2, v3, new Edge(v2,v3,
//                new ConnectionType(ConnectionType.ConnType.EndConnection_StraightEdge,
//                        ConnectionType.ConnectionSide.Down,
//                        ConnectionType.ConnectionSide.Up,
//                        ConnectionType.CenterRelativePosition.DownLeft)));
//        graph.addEdge(v3, v4, new Edge(v3,v4,
//                new ConnectionType(ConnectionType.ConnType.EndConnection_StraightEdge,
//                        ConnectionType.ConnectionSide.Up,
//                        ConnectionType.ConnectionSide.Down,
//                        ConnectionType.CenterRelativePosition.UpLeft)));
//        graph.addEdge(v4, v1, new Edge(v4,v1,
//                new ConnectionType(ConnectionType.ConnType.EndConnection_StraightEdge,
//                        ConnectionType.ConnectionSide.Up,
//                        ConnectionType.ConnectionSide.Down,
//                        ConnectionType.CenterRelativePosition.UpRight)));
//
//        graph.addEdge(v1, v5, new Edge(v1,v5,
//                new ConnectionType(ConnectionType.ConnType.FullyConnected,
//                        ConnectionType.CenterRelativePosition.Down)));
//        graph.addEdge(v2, v6, new Edge(v2,v6,
//                new ConnectionType(ConnectionType.ConnType.FullyConnected,
//                        ConnectionType.CenterRelativePosition.Left)));
//        graph.addEdge(v3, v7, new Edge(v3,v7,
//                new ConnectionType(ConnectionType.ConnType.FullyConnected,
//                        ConnectionType.CenterRelativePosition.Up)));
//        graph.addEdge(v4, v8, new Edge(v4,v8,
//                new ConnectionType(ConnectionType.ConnType.FullyConnected,
//                        ConnectionType.CenterRelativePosition.Right)));
//
//
//        graph.addEdge(v5, v6, new Edge(v5,v6,
//                new ConnectionType(ConnectionType.ConnType.EndConnection_StraightEdge,
//                        ConnectionType.ConnectionSide.Down,
//                        ConnectionType.ConnectionSide.Up,
//                        ConnectionType.CenterRelativePosition.DownRight)));
//        graph.addEdge(v6, v7, new Edge(v6,v7,
//                new ConnectionType(ConnectionType.ConnType.EndConnection_StraightEdge,
//                        ConnectionType.ConnectionSide.Down,
//                        ConnectionType.ConnectionSide.Up,
//                        ConnectionType.CenterRelativePosition.DownLeft)));
//        graph.addEdge(v7, v8, new Edge(v7,v8,
//                new ConnectionType(ConnectionType.ConnType.EndConnection_StraightEdge,
//                        ConnectionType.ConnectionSide.Up,
//                        ConnectionType.ConnectionSide.Down,
//                        ConnectionType.CenterRelativePosition.UpLeft)));
//        graph.addEdge(v8, v5, new Edge(v8,v5,
//                new ConnectionType(ConnectionType.ConnType.EndConnection_StraightEdge,
//                        ConnectionType.ConnectionSide.Up,
//                        ConnectionType.ConnectionSide.Down,
//                        ConnectionType.CenterRelativePosition.UpRight)));
//
//
//
//
//        graph.addEdge(v5, v9, new Edge(v5,v9,
//                new ConnectionType(ConnectionType.ConnType.MidConnection,
//                        ConnectionType.CenterRelativePosition.Down,
//                        -10)));
//        graph.addEdge(v7, v9, new Edge(v7,v9,
//                new ConnectionType(ConnectionType.ConnType.MidConnection,
//                        ConnectionType.CenterRelativePosition.Up,
//                        -10)));
//
//
//        // 打印图来验证连接
//        graph.printGraph();
//
//        JFrame frame = new JFrame("Window.Graph.Graph Drawing");
//        GraphPanel panel = new GraphPanel(graph);
//
//
//
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口关闭行为，当窗口关闭时退出整个程序
//        frame.setLocationRelativeTo(null); // 将窗口置于屏幕中央
//        frame.pack(); // 自动调整窗口大小以适应内容的首选大小和布局
//        frame.setSize(600, 600); // 设置窗口的大小为600x600像素
//        frame.getContentPane().add(panel); // 将GraphPanel添加到JFrame的内容面板中
//        frame.setVisible(true); // 使窗口可见
//
//    }
}
