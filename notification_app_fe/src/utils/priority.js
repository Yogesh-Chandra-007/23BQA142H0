function getWeight(type) {

  switch (type.toLowerCase()) {

    case "placement":
      return 3;

    case "result":
      return 2;

    default:
      return 1;
  }
}

export function getPriorityNotifications(
  notifications,
  count = 10
) {

  return [...notifications]
    .sort((a, b) => {

      const weightDiff =
        getWeight(b.Type) -
        getWeight(a.Type);

      if (weightDiff !== 0) {
        return weightDiff;
      }

      return (
        new Date(b.Timestamp) -
        new Date(a.Timestamp)
      );
    })
    .slice(0, count);
}
