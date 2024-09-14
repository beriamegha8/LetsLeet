class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        
        // Initialize variables to store the previous two results
        int oneStepBefore = 2; // ways to reach n-1
        int twoStepsBefore = 1; // ways to reach n-2
        int currentWays = 0;
        //(reverse fibonacci)
        for (int i = 3; i <= n; i++) {
            currentWays = oneStepBefore + twoStepsBefore; // ways(n) = ways(n-1) + ways(n-2)
            twoStepsBefore = oneStepBefore;
            oneStepBefore = currentWays;
        }
        return currentWays;
    }
}
