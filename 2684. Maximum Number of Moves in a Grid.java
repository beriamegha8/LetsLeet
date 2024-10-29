class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // dp[i][j] represents if we can reach cell (i,j)
        boolean[][] dp = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = true;
        }
        int maxMoves = 0;
        for (int j = 0; j < n - 1; j++) {
            boolean moved = false;
            for (int i = 0; i < m; i++) {
                if (!dp[i][j]) continue;
                for (int newRow = i - 1; newRow <= i + 1; newRow++) {
                    if (newRow >= 0 && newRow < m) {
                        if (grid[newRow][j + 1] > grid[i][j]) {
                            dp[newRow][j + 1] = true;
                            moved = true;
                        }
                    }
                }
            }
            if (moved) {
                maxMoves++;
            } else {
                break;
            }
        }
        
        return maxMoves;
    }
}
