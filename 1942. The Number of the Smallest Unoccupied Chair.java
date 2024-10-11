import java.util.*;

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        List<int[]> events = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            events.add(new int[]{times[i][0], i, 1}); // Arrival event
            events.add(new int[]{times[i][1], i, 0}); // Leaving event
        }
        // Sort events by time, in case of tie, process leaving events first
        Collections.sort(events, (a, b) -> a[0] == b[0] ? a[2] - b[2] : a[0] - b[0]);
        // Min-heap to store available chair numbers
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableChairs.add(i);
        }
        int[] friendToChair = new int[n];
        for (int[] event : events) {
            int time = event[0];
            int friend = event[1];
            int type = event[2]; // 1 for arrival, 0 for leaving
            
            if (type == 1) { // Arrival event
                int chair = availableChairs.poll();
                friendToChair[friend] = chair;
                if (friend == targetFriend) {
                    return chair;
                }
            } else { // Leaving event
                availableChairs.add(friendToChair[friend]);
            }
        }
        return -1; // This shouldn't be reached
    }
}
