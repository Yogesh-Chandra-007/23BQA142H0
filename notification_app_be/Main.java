import java.util.List;

public class Main {

    public static void main(String[] args) {

        NotificationService service = new NotificationService();

        long now = System.currentTimeMillis();

        service.addNotification(
                new Notification(
                        "N1",
                        "EVENT",
                        now - 10000,
                        false
                )
        );

        service.addNotification(
                new Notification(
                        "N2",
                        "RESULT",
                        now - 5000,
                        false
                )
        );

        service.addNotification(
                new Notification(
                        "N3",
                        "PLACEMENT",
                        now - 2000,
                        false
                )
        );

        service.addNotification(
                new Notification(
                        "N4",
                        "PLACEMENT",
                        now,
                        false
                )
        );

        List<Notification> topNotifications =
                service.getTopNotifications(10);

        for (Notification notification : topNotifications) {
            System.out.println(notification);
        }
    }
}
