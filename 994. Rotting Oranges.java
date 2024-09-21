class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        
        if (freshOranges == 0) return 0;
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int minutes = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotten = false;
            
            for (int i = 0; i < size; i++) {
                int[] orange = queue.poll();
                int row = orange[0];
                int col = orange[1];
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // Mark as rotten
                        queue.offer(new int[]{newRow, newCol});
                        freshOranges--; // One less fresh orange
                        rotten = true;
                    }
                }
            }
            if (rotten) {
                minutes++;
            }
        }
        return freshOranges == 0 ? minutes : -1;
    }
}
