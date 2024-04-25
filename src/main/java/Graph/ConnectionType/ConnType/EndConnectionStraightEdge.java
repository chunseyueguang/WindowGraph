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

    public EndConnectionStraightEdge(Vertex.ConnectionSide sourceSide, Vertex.ConnectionSide destinationSide) {
        this.sourceSide = sourceSide;
        this.destinationSide = destinationSide;
    }



    private Vertex.ConnectionSide sourceSide;
    private Vertex.ConnectionSide destinationSide;

    public Vertex.ConnectionSide getSourceSide() {
        return sourceSide;
    }

    public void setSourceSide(Vertex.ConnectionSide sourceSide) {
        this.sourceSide = sourceSide;
    }

    public Vertex.ConnectionSide getDestinationSide() {
        return destinationSide;
    }

    public void setDestinationSide(Vertex.ConnectionSide destinationSide) {
        this.destinationSide = destinationSide;
    }

    public void calculateDestinationNodeCenterCoordinate(Vertex source, Vertex destination, Vertex.ConnectionSide sourceConnectionSide, Vertex.ConnectionSide destinationConnectionSide, ConnectionType.CenterRelativePosition source2destination){
        if(sourceConnectionSide == Vertex.ConnectionSide.Down && destinationConnectionSide == Vertex.ConnectionSide.Up){
            if(source2destination == ConnectionType.CenterRelativePosition.DownRight){
                destination.setX(source.getX() + source.getXDistance() / 2 - destination.getXDistance() / 2);
                destination.setY(source.getY() + source.getYDistance() / 2 + destination.getYDistance() / 2);
            } else if (source2destination == ConnectionType.CenterRelativePosition.DownLeft) {
                destination.setX(source.getX() + source.getXDistance() / 2 - destination.getXDistance() / 2);
                destination.setY(source.getY() + source.getYDistance() / 2 + destination.getYDistance() / 2);
            }
        } else if (sourceConnectionSide == Vertex.ConnectionSide.Up && destinationConnectionSide == Vertex.ConnectionSide.Down) {
            if(source2destination == ConnectionType.CenterRelativePosition.UpRight){
                destination.setX(source.getX() - source.getXDistance() / 2 + destination.getXDistance() / 2);
                destination.setY(source.getY() - source.getYDistance() / 2 - destination.getYDistance() / 2);
            } else if (source2destination == ConnectionType.CenterRelativePosition.UpLeft) {
//                System.out.println("----------source-------"+source+"\n-----destination------------"+destination);
//                System.out.println("source.getXDistance() / 2  "+source.getXDistance() / 2 + "  destination.getXDistance() / 2  "+destination.getXDistance() / 2);
                destination.setX(source.getX() - source.getXDistance() / 2 + destination.getXDistance() / 2);
                destination.setY(source.getY() - source.getYDistance() / 2 - destination.getYDistance() / 2);

            }


        } else if (sourceConnectionSide == Vertex.ConnectionSide.Right && destinationConnectionSide == Vertex.ConnectionSide.Left) {
            if (source2destination == ConnectionType.CenterRelativePosition.DownRight) {
                destination.setX(source.getX() + source.getXDistance() / 2 + destination.getXDistance() / 2);
                destination.setY(source.getY() - source.getYDistance() / 2 + destination.getYDistance() / 2);
            } else if (source2destination == ConnectionType.CenterRelativePosition.UpRight) {
                destination.setX(source.getX() + source.getXDistance() / 2 + destination.getXDistance() / 2);
                destination.setY(source.getY() + source.getYDistance() / 2 - destination.getYDistance() / 2);
            }
        } else if (sourceConnectionSide == Vertex.ConnectionSide.Left && destinationConnectionSide == Vertex.ConnectionSide.Right) {
            if (source2destination == ConnectionType.CenterRelativePosition.DownLeft) {
                destination.setX(source.getX() - source.getXDistance() / 2 - destination.getXDistance() / 2);
                destination.setY(source.getY() + source.getYDistance() / 2 - destination.getYDistance() / 2);
            } else if (source2destination == ConnectionType.CenterRelativePosition.UpLeft) {
                destination.setX(source.getX() - source.getXDistance() / 2 - destination.getXDistance() / 2);
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
                "vertexSide_u=" + sourceSide +
                ", vertexSide_v=" + destinationSide +
                '}';
    }
}
