package GraphConfig;

public class EdgeConfig {
    private String from;
    private String to;
    private ConnectionTypeConfig connectionType;

    // Getters and Setters
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public ConnectionTypeConfig getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(ConnectionTypeConfig connectionType) {
        this.connectionType = connectionType;
    }
}