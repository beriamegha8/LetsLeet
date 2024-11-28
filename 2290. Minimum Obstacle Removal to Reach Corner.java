class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        
        // Deque for 0-1 BFS
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0, 0}); // {row, col, obstacles}
        boolean[][] visited = new boolean[m][n];
        
        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int row = current[0];
            int col = current[1];
            int obstacles = current[2];
            
            if (row == m - 1 && col == n - 1) {
                return obstacles;
            }
            
            // Skip if already visited with fewer or equal obstacles
            if (visited[row][col]) continue;
            visited[row][col] = true;
            
            // Explore 4 directions
            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    int newObstacles = obstacles + (grid[newRow][newCol] == 1 ? 1 : 0);
                    
                    // If we can improve the path to this cell
                    if (!visited[newRow][newCol] && newObstacles < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newObstacles;
                        
                        if (grid[newRow][newCol] == 0) {
                            deque.offerFirst(new int[]{newRow, newCol, newObstacles});
                        } else {
                            deque.offerLast(new int[]{newRow, newCol, newObstacles});
                        }
                    }
                }
            }
        }
        // Should never reach here given the problem constraints
        return -1;
    }
}
