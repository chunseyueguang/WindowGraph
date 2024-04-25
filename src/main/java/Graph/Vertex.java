package Graph;

public class Vertex {
    public enum ConnectionSide {
        Up,
        Down,
        Left,
        Right
    }

    public String name;
    public int longSide;     // 长
    public int shortSide = 10;
    public double rotationAngle = 0;   // 旋转
    public int x = 0;
    public int y = 0;

//    public int trapeziumAngle = 45;   // 绘制梯形 角度
    public enum trapeziumDirection{
        Up,
        Down,
        Left,
        Right,
        None
    }

    public trapeziumDirection direction = trapeziumDirection.None;

    public Vertex() {
    }

    public Vertex(String name, int longSide, double RotationAngle ) {
        this.name = name;
        this.longSide = longSide;
        this.rotationAngle = RotationAngle;
        this.x = 0;
        this.y = 0;
    }
    public Vertex(String name, int longSide,  int x, int y,double RotationAngle  ) {
        this.name = name;
        this.longSide = longSide;
        this.rotationAngle = RotationAngle;
        this.x = x;
        this.y = y;
    }

    public Vertex(String name, int longSide, double rotationAngle, trapeziumDirection direction) {
        this.name = name;
        this.longSide = longSide;
        this.rotationAngle = rotationAngle;
        this.direction = direction;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLongSide() {
        return longSide;
    }

    public int getShortSide() {
        return shortSide;
    }

    public int getXDistance() {
        if(rotationAngle == 0 || rotationAngle == Math.PI)
            return longSide;
        return shortSide;
    }

    public int getYDistance() {
        if(rotationAngle == 0 || rotationAngle == Math.PI)
            return shortSide;
        return longSide;
    }
    public String getName() {
        return name;
    }

    public double getRotationAngle() {
        return rotationAngle;
    }

    public trapeziumDirection getDirection() {
        return direction;
    }


    // 重写 equals 方法，现在使用 name 来判断两个 Vertex 是否相等
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return name != null ? name.equals(vertex.name) : vertex.name == null;
    }

    // 重写 hashCode 方法，也基于 name 属性
    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                ", longSide=" + longSide +
                ", shortSide=" + shortSide +
                ", rotationAngle=" + rotationAngle +
                ", x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }
}