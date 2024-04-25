package Graph.ConnectionType.ConnType;

import Graph.ConnectionType.ConnectionType;
import Graph.Vertex;

public class EndConnectionStraightEdge implements ConnType{ // 直边端点 连接

    double normalizedAngle = 0;


    public EndConnectionStraightEdge() {
    }

    public EndConnectionStraightEdge(double normalizedAngle) {
        this.normalizedAngle = normalizedAngle;
    }

    public void calculateDestinationNodeCenterCoordinate(Vertex source, Vertex destination, double normalizedAngle, ConnectionType.CenterRelativePosition source2destination){
        if(normalizedAngle == 0){
            if(source2destination == ConnectionType.CenterRelativePosition.DownRight){
                destination.setX(source.getX() + source.getXDistance() / 2 - destination.getXDistance() / 2);
                destination.setY(source.getY() + source.getYDistance() / 2 + destination.getYDistance() / 2);
            } else if (source2destination == ConnectionType.CenterRelativePosition.DownLeft) {
                destination.setX(source.getX() + source.getXDistance() / 2 - destination.getXDistance() / 2);
                destination.setY(source.getY() + source.getYDistance() / 2 + destination.getYDistance() / 2);
            }
        } else if (normalizedAngle == Math.PI) {
            if(source2destination == ConnectionType.CenterRelativePosition.UpRight){
                destination.setX(source.getX() - source.getXDistance() / 2 + destination.getXDistance() / 2);
                destination.setY(source.getY() - source.getYDistance() / 2 - destination.getYDistance() / 2);
            } else if (source2destination == ConnectionType.CenterRelativePosition.UpLeft) {
                destination.setX(source.getX() - source.getXDistance() / 2 + destination.getXDistance() / 2);
                destination.setY(source.getY() - source.getYDistance() / 2 - destination.getYDistance() / 2);

            }


        } else if (normalizedAngle == Math.PI/2) {
            if (source2destination == ConnectionType.CenterRelativePosition.DownRight) {
                destination.setX(source.getX() + source.getXDistance() / 2 + destination.getXDistance() / 2);
                destination.setY(source.getY() - source.getYDistance() / 2 + destination.getYDistance() / 2);
            } else if (source2destination == ConnectionType.CenterRelativePosition.DownLeft) {
                destination.setX(source.getX() - source.getXDistance() / 2 - destination.getXDistance() / 2);
                destination.setY(source.getY() + source.getYDistance() / 2 - destination.getYDistance() / 2);
            }
        } else if (normalizedAngle == Math.PI/2*3) {
            if (source2destination == ConnectionType.CenterRelativePosition.UpLeft) {
                destination.setX(source.getX() - source.getXDistance() / 2 - destination.getXDistance() / 2);
                destination.setY(source.getY() + source.getYDistance() / 2 - destination.getYDistance() / 2);
            }
            else if (source2destination == ConnectionType.CenterRelativePosition.UpRight) {
                destination.setX(source.getX() + source.getXDistance() / 2 + destination.getXDistance() / 2);
                destination.setY(source.getY() + source.getYDistance() / 2 - destination.getYDistance() / 2);
            }
        }

        System.out.println("destination = "+destination.getName() + "  -> " + destination.getX() + "  -> " + destination.getY() + "  -> " + destination.getLongSide() + "  -> " + destination.getShortSide());


    }

    public double getNormalizedAngle() {
        return normalizedAngle;
    }

    public void setNormalizedAngle(double normalizedAngle) {
        this.normalizedAngle = normalizedAngle % 360; // 正规化
    }

    @Override
    public String toString() {
        return "EndConnectionStraightEdge{" +
                "normalizedAngle=" + normalizedAngle +
                '}';
    }
}
