package Graph.ConnectionType.ConnType;

import Graph.ConnectionType.ConnectionType;
import Graph.Vertex;

public class EndConnectionObliqueEdge implements ConnType{  //斜边端点 连接
    public EndConnectionObliqueEdge() {
    }
    public void calculateDestinationNodeCenterCoordinate(Vertex source, Vertex destination, Vertex.trapeziumDirection direction , ConnectionType.CenterRelativePosition source2destination) {
        if(direction == Vertex.trapeziumDirection.Down){
            if(source2destination == ConnectionType.CenterRelativePosition.DownRight){
                destination.setX(source.getX() + source.getXDistance() / 2 - destination.getXDistance() / 2);
                destination.setY(source.getY() - source.getYDistance() / 2 + destination.getYDistance() / 2);
            } else if (source2destination == ConnectionType.CenterRelativePosition.DownLeft) {
                destination.setX(source.getX() - source.getXDistance() / 2 + destination.getXDistance() / 2);
                destination.setY(source.getY() - source.getYDistance() / 2 + destination.getYDistance() / 2);
            }
        } else if (direction == Vertex.trapeziumDirection.Up) {
            if (source2destination == ConnectionType.CenterRelativePosition.UpLeft) {
                destination.setX(source.getX() - source.getXDistance() / 2 + destination.getXDistance() / 2);
                destination.setY(source.getY() + source.getYDistance() / 2 - destination.getYDistance() / 2);
            } else if (source2destination == ConnectionType.CenterRelativePosition.UpRight) {
                destination.setX(source.getX() + source.getXDistance() / 2 - destination.getXDistance() / 2);
                destination.setY(source.getY() + source.getYDistance() / 2 - destination.getYDistance() / 2);
            }
        } else if (direction == Vertex.trapeziumDirection.Right) {
            if (source2destination == ConnectionType.CenterRelativePosition.DownRight) {
                destination.setX(source.getX() - source.getXDistance() / 2 + destination.getXDistance() / 2);
                destination.setY(source.getY() + source.getYDistance() / 2 - destination.getYDistance() / 2);
            } else if (source2destination == ConnectionType.CenterRelativePosition.UpRight) {
                destination.setX(source.getX() - source.getXDistance() / 2 + destination.getXDistance() / 2);
                destination.setY(source.getY() - source.getYDistance() / 2 + destination.getYDistance() / 2);
            }
        }else if(direction == Vertex.trapeziumDirection.Left){
            if (source2destination == ConnectionType.CenterRelativePosition.DownLeft) {
                destination.setX(source.getX() - destination.getXDistance() / 2 + source.getXDistance() / 2);
                destination.setY(source.getY() - destination.getYDistance() / 2 + source.getYDistance() / 2);
            } else if (source2destination == ConnectionType.CenterRelativePosition.UpLeft) {
                destination.setX(source.getX() + source.getXDistance() / 2 - destination.getXDistance() / 2);
                destination.setY(source.getY() - source.getYDistance() / 2 + destination.getYDistance() / 2);
            }
        }

        System.out.println("destination = "+destination.getName() + "  -> " + destination.getX() + "  -> " + destination.getY() + "  -> " + destination.getLongSide() + "  -> " + destination.getShortSide());

    }
}
