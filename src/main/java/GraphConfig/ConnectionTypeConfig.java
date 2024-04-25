package GraphConfig;

public class ConnectionTypeConfig {
    private String type; // 如 "EndConnectionObliqueEdge", "FullConnection", "MidConnection"
    private String position; // 如 "DownRight", "Left", "Up"
    private Integer offset; // Optional, only for some connection types

    private String sourceSide;
    private String targetSide;

    public String getSourceSide() {
        return sourceSide;
    }

    public void setSourceSide(String sourceSide) {
        this.sourceSide = sourceSide;
    }

    public String getTargetSide() {
        return targetSide;
    }

    public void setTargetSide(String targetSide) {
        this.targetSide = targetSide;
    }

    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}