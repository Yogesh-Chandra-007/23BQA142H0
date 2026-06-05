import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NotificationService {

    private final PriorityQueue<Notification> priorityQueue;

    public NotificationService() {
        priorityQueue = new PriorityQueue<>(
                (a, b) -> Long.compare(getScore(b), getScore(a))
        );
    }

    private long getScore(Notification notification) {

        int weight;

        switch (notification.getType().toUpperCase()) {
            case "PLACEMENT":
                weight = 3;
                break;
            case "RESULT":
                weight = 2;
                break;
            default:
                weight = 1;
        }

        return weight * 1_000_000_000_000L + notification.getTimestamp();
    }

    public void addNotification(Notification notification) {
        if (!notification.isRead()) {
            priorityQueue.offer(notification);
        }
    }

    public List<Notification> getTopNotifications(int n) {

        List<Notification> result = new ArrayList<>();
        List<Notification> temp = new ArrayList<>();

        while (n > 0 && !priorityQueue.isEmpty()) {
            Notification current = priorityQueue.poll();
            result.add(current);
            temp.add(current);
            n--;
        }

        priorityQueue.addAll(temp);

        return result;
    }
}
