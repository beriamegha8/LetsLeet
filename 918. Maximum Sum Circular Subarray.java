class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int currentMax = 0;
        int currentMin = 0;

        for (int num : nums) {
            totalSum += num;

            // Kadane's algorithm to find maximum sum subarray
            currentMax = Math.max(currentMax + num, num);
            maxSum = Math.max(maxSum, currentMax);

            // Kadane's algorithm to find minimum sum subarray
            currentMin = Math.min(currentMin + num, num);
            minSum = Math.min(minSum, currentMin);
        }

        // If all numbers are negative, maxSum will give the correct answer
        if (maxSum < 0) {
            return maxSum;
        }

        // Maximum of non-circular subarray (maxSum) and circular subarray (totalSum - minSum)
        return Math.max(maxSum, totalSum - minSum);
    }
}
