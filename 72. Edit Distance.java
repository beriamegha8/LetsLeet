class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // DP table
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the DP table
        // If word1 is empty, we need to insert all characters of word2
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // If word2 is empty, we need to delete all characters of word1
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // No operation needed if characters match
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Take the minimum of insert, delete, or replace
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], // Delete
                                            Math.min(dp[i][j - 1], // Insert
                                                     dp[i - 1][j - 1])); // Replace
                }
            }
        }

        // The answer is in dp[m][n]
        return dp[m][n];
    }
}
