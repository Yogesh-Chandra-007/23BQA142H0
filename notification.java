import java.time.Instant;

public class Notification {
    private final String id;
    private final String type; // "placement", "result", "event"
    private final String message;
    private final Instant timestamp;
    private boolean isRead;

    public Notification(String id, String type, String message, Instant timestamp) {
        this.id = id;
        this.type = type.toLowerCase();
        this.message = message;
        this.timestamp = timestamp;
        this.isRead = false;
    }

    public String getId() { return id; }
    public String getType() { return type; }
    public String getMessage() { return message; }
    public Instant getTimestamp() { return timestamp; }
    public boolean isRead() { return isRead; }
    public void markAsRead() { this.isRead = true; }

    public int getTypeWeight() {
        switch (this.type) {
            case "placement": return 3;
            case "result": return 2;
            case "event": return 1;
            default: return 0;
        }
    }
}
