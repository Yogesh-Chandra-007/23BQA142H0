import java.time.LocalDateTime;

public class Notification {

    private String id;
    private String type;
    private String message;
    private LocalDateTime timestamp;

    public Notification(String id, String type, String message, LocalDateTime timestamp) {
        this.id = id;
        this.type = type;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
