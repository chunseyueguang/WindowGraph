package Graph.ConnectionType;

import Graph.ConnectionType.ConnType.ConnType;
import Graph.Vertex;

import java.lang.reflect.Constructor;

public class ConnectionType {
    public enum CenterRelativePosition {    // 定义两个节点的 相对方向：  目标节点相对于源节点的位置
        DownRight,  // 目标节点 处于 源节点 右下方
        DownLeft,   // 目标节点 处于 源节点 左下方
        UpRight,    // 目标节点 处于 源节点 右上方
        UpLeft,    // 目标节点 处于 源节点 左上方
        Up,        // 目标节点 处于 源节点 上方
        Down,       // 目标节点 处于 源节点 下方
        Left,       // 目标节点 处于 源节点 左方
        Right       // 目标节点 处于 源节点 右方
    }

    public ConnType connType;
    public CenterRelativePosition v2u;      // 两个节点的中心相对位置
    public int deviation = 0;   // 偏差
    public double angle = 0;    // 定义一个0-360度的角度
    public Vertex.ConnectionSide sourceSide;
    public ConnectionType() {
    }

    public ConnectionType(ConnType connType) {
        this.connType = connType;
    }


    public ConnectionType(Vertex u, Vertex v,ConnType connType, CenterRelativePosition v2u) {
        this.connType = connType;
        this.v2u = v2u;
    }

    public ConnectionType(ConnType connType, CenterRelativePosition v2u) {
        this.connType = connType;
        this.v2u = v2u;
    }

    public ConnectionType(ConnType connType, CenterRelativePosition v2u, int deviation) {
        this.connType = connType;
        this.v2u = v2u;
        this.deviation = deviation;
    }

    public ConnType getConnType() {
        return connType;
    }


    public CenterRelativePosition getV2u() {
        return v2u;
    }

    public int getDeviation() {
        return deviation;
    }

    public static ConnType createConnectionType(String typeName) throws Exception {
        String baseClassName = "Graph.ConnectionType.ConnType";
        String fullClassName = baseClassName + "." + typeName;
        Class<?> clazz = Class.forName(fullClassName);  // 获取类对象
        return (ConnType) clazz.getDeclaredConstructor().newInstance();
    }

    public static ConnType createConnectionType(String typeName, String param1, String param2) throws Exception {
        String baseClassName = "Graph.ConnectionType.ConnType";
        String fullClassName = baseClassName + "." + typeName;
        System.out.println(fullClassName);

        // 获取类对象
        Class<?> clazz = Class.forName(fullClassName);

        // 获取对应的构造函数，这里假设构造函数的参数都是String类型
        Constructor<?> constructor = clazz.getDeclaredConstructor(Vertex.ConnectionSide.class, Vertex.ConnectionSide.class);
        // 将字符串参数转换为枚举值
        Vertex.ConnectionSide side1 = Vertex.ConnectionSide.valueOf(param1);
        Vertex.ConnectionSide side2 = Vertex.ConnectionSide.valueOf(param2);
        // 创建实例
        return (ConnType) constructor.newInstance(side1, side2);
    }

    @Override
    public String toString() {
        return "ConnectionType{" +
                ", connType=" + connType +
                ", v2u=" + v2u +
                '}';
    }
}
