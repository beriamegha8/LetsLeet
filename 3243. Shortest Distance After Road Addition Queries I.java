class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(i + 1);
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            graph.get(u).add(v);
            
            // Find shortest path using BFS
            answer[i] = bfs(graph, n);
        }
        
        return answer;
    }
    private int bfs(List<List<Integer>> graph, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        // Queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == n - 1) {
                return dist[n - 1];
            }
            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    dist[neighbor] = dist[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        return -1;
    }
}
