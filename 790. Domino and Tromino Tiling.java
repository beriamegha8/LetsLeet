class Solution {
    public int numTilings(int n) {
        if (n <= 2) return n;
        long[] dp = new long[n + 1];
        int mod = 1000000007;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= n; i++) {
            dp[i] = (2 * dp[i-1] + dp[i-3]) % mod;
        }
        return (int) dp[n];
    }
}
