class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n]; // DP table to store largest square size at each position
        int totalSquares = 0;

        // Traverse the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        // First row or first column can only form squares of size 1
                        dp[i][j] = 1;
                    } else {
                        // Calculate the size of the largest square ending at (i, j)
                        dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    }
                    totalSquares += dp[i][j]; // Accumulate the number of squares
                }
            }
        }

        return totalSquares;
    }
}
