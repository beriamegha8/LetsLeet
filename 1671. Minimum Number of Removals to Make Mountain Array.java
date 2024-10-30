class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        // Arrays to store LIS lengths from the left and right
        int[] leftLIS = new int[n];
        int[] rightLIS = new int[n];
        
        // Compute LIS from the left for each element
        for (int i = 0; i < n; i++) {
            leftLIS[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    leftLIS[i] = Math.max(leftLIS[i], leftLIS[j] + 1);
                }
            }
        }
        
        // Compute LIS from the right for each element
        for (int i = n - 1; i >= 0; i--) {
            rightLIS[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    rightLIS[i] = Math.max(rightLIS[i], rightLIS[j] + 1);
                }
            }
        }

        int maxMountainLength = 0;

        // Calculate the maximum possible mountain length
        for (int i = 1; i < n - 1; i++) {
            if (leftLIS[i] > 1 && rightLIS[i] > 1) {
                // Valid peak: both increasing and decreasing subsequences exist
                maxMountainLength = Math.max(maxMountainLength, leftLIS[i] + rightLIS[i] - 1);
            }
        }

        // Minimum removals to make the mountain array
        return n - maxMountainLength;
    }
}
