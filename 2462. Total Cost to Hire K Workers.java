class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> firstCandidates = new PriorityQueue<>((a, b) -> 
            costs[a] == costs[b] ? a - b : costs[a] - costs[b]);
        PriorityQueue<Integer> lastCandidates = new PriorityQueue<>((a, b) -> 
            costs[a] == costs[b] ? a - b : costs[a] - costs[b]);
        
        int left = 0, right = costs.length - 1;
        
        for (int i = 0; i < candidates && left <= right; i++) {
            firstCandidates.offer(left);
            if (left != right) {
                lastCandidates.offer(right);
            }
            left++;
            right--;
        }
        
        long totalCost = 0;
        
        for (int i = 0; i < k; i++) {
            if (lastCandidates.isEmpty() || 
                (!firstCandidates.isEmpty() && 
                 (costs[firstCandidates.peek()] <= costs[lastCandidates.peek()]))) {
                // Choose from first candidates
                int index = firstCandidates.poll();
                totalCost += costs[index];
                
                // Add new candidate from left if possible
                if (left <= right) {
                    firstCandidates.offer(left);
                    left++;
                }
            } else {
                // Choose from last candidates
                int index = lastCandidates.poll();
                totalCost += costs[index];
                
                // Add new candidate from right if possible
                if (left <= right) {
                    lastCandidates.offer(right);
                    right--;
                }
            }
        }
        
        return totalCost;
    }
}
