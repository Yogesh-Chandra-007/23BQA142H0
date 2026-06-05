# Notification Priority Inbox System

## Objective

Display top N unread notifications based on:
1. Notification Type Weight
2. Recency

Priority Order:
Placement > Result > Event

## Weight Mapping

Placement = 3
Result = 2
Event = 1

## Priority Formula

score = weight * CONSTANT + timestamp

## Data Structure

Priority Queue (Max Heap)

Insertion: O(log N)

Top K Retrieval: O(K log N)

## Scalability

Supports continuous notification arrival and efficient retrieval of top priority notifications.
