import java.util.*;

public class NotificationService {

    private final PriorityQueue<Notification> heap;

    public NotificationService() {

        heap = new PriorityQueue<>((a, b) -> {

            int weightA = getWeight(a.getType());
            int weightB = getWeight(b.getType());

            if (weightA != weightB) {
                return Integer.compare(weightB, weightA);
            }

            return b.getTimestamp().compareTo(a.getTimestamp());
        });
    }

    private int getWeight(String type) {

        switch (type.toUpperCase()) {

            case "PLACEMENT":
                return 3;

            case "RESULT":
                return 2;

            default:
                return 1;
        }
    }

    public void addNotification(Notification notification) {
        heap.offer(notification);
    }

    public List<Notification> getTopNotifications(int n) {

        List<Notification> result = new ArrayList<>();
        List<Notification> temp = new ArrayList<>();

        while (!heap.isEmpty() && n-- > 0) {

            Notification current = heap.poll();

            result.add(current);
            temp.add(current);
        }

        heap.addAll(temp);

        return result;
    }
}
