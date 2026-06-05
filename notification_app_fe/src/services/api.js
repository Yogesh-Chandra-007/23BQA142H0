const API_URL =
  "http://4.224.186.213/evaluation-service/notifications";

export async function fetchNotifications(token) {

  const response = await fetch(API_URL, {
    headers: {
      Authorization: `Bearer ${token}`
    }
  });

  if (!response.ok) {
    throw new Error("Failed to fetch notifications");
  }

  const data = await response.json();

  return data.notifications;
}
