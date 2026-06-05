import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityNotificationManager {
    private final int capacity;
    
    // Combine structural weight (Primary) and Recency (Secondary)
    private final Comparator<Notification> notificationComparator = (n1, n2) -> {
        int weightCompare = Integer.compare(n2.getTypeWeight(), n1.getTypeWeight());
        if (weightCompare != 0) {
            return weightCompare;
        }
        return n2.getTimestamp().compareTo(n1.getTimestamp()); // Newer timestamps first
    };

    // Min-Heap orientation stores elements where the least prioritized sits at the peak
    private final PriorityQueue<Notification> minHeap;

    public PriorityNotificationManager(int capacity) {
        this.capacity = capacity;
        // Invert comparator for a bounded Min-Heap to drop bottom-tier entries automatically
        this.minHeap = new PriorityQueue<>(notificationComparator.reversed());
    }

    public synchronized void ingressNotification(Notification notification) {
        if (notification == null || notification.isRead()) return;

        if (minHeap.size() < capacity) {
            minHeap.offer(notification);
        } else {
            Notification lowestPriorityTopNotification = minHeap.peek();
            if (notificationComparator.compare(notification, lowestPriorityTopNotification) < 0) {
                minHeap.poll(); // Evict bottom-tier node
                minHeap.offer(notification);
            }
        }
    }

    public synchronized List<Notification> getTopNotifications() {
        List<Notification> sortedList = new ArrayList<>(minHeap);
        sortedList.sort(notificationComparator);
        return sortedList;
    }
}
