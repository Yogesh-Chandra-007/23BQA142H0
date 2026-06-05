export default function NotificationCard({ notification }) {
  return (
    <div>
      <h3>{notification.Type}</h3>
      <p>{notification.Message}</p>
      <small>{notification.Timestamp}</small>
    </div>
  );
}
