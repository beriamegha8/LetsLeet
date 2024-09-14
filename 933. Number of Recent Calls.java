class RecentCounter {
    private Queue<Integer> queue;  // Queue to store the timestamps of pings
    public RecentCounter() {
        queue = new LinkedList<>();  // Initialize the queue
    }
    public int ping(int t) {
        queue.add(t);
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
