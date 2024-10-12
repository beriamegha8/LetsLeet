import java.util.*;

class Solution {
    public int minGroups(int[][] intervals) {
        // Use TreeMap to store events: +1 for start, -1 for end + 1
        TreeMap<Integer, Integer> events = new TreeMap<>();
        for (int[] interval : intervals) {
            events.put(interval[0], events.getOrDefault(interval[0], 0) + 1);
            events.put(interval[1] + 1, events.getOrDefault(interval[1] + 1, 0) - 1);
        }
        int maxGroups = 0, currentGroups = 0;
        // Traverse the events in sorted order
        for (int count : events.values()) {
            currentGroups += count;
            maxGroups = Math.max(maxGroups, currentGroups);
        }
        return maxGroups;
    }
}
