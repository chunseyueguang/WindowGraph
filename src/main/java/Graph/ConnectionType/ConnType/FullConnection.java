package Graph.ConnectionType.ConnType;

import Graph.ConnectionType.ConnectionType;
import Graph.Vertex;

public class FullConnection implements ConnType {    // 两个直边 连接在一起
    public FullConnection() {
    }

    public void calculateDestinationNodeCenterCoordinate(Vertex source, Vertex destination, ConnectionType.CenterRelativePosition source2destination) {

        if (source2destination == ConnectionType.CenterRelativePosition.Down) {
            destination.setX(source.getX());
            destination.setY(source.getY() + source.getYDistance()/2 + destination.getYDistance()/2);
        }else if(source2destination == ConnectionType.CenterRelativePosition.Up){
            destination.setX(source.getX());
            destination.setY(source.getY() - source.getYDistance()/2 - destination.getYDistance()/2);
        }else if(source2destination == ConnectionType.CenterRelativePosition.Left){
            destination.setX(source.getX() - source.getXDistance()/2 - destination.getXDistance()/2);
            destination.setY(source.getY());
        }else if(source2destination == ConnectionType.CenterRelativePosition.Right){
            destination.setX(source.getX() + source.getXDistance()/2 + destination.getXDistance()/2);
            destination.setY(source.getY());
        }
        System.out.println("destination = "+destination.getName() + "  -> " + destination.getX() + "  -> " + destination.getY() + "  -> " + destination.getLongSide() + "  -> " + destination.getShortSide());

    }
}
