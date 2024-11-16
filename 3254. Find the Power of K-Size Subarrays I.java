class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];
        
        for (int i = 0; i <= n - k; i++) {
            boolean isConsecutive = true;
            int maxElement = nums[i]; // Start with the first element in the subarray
            
            for (int j = i + 1; j < i + k; j++) {
                // Check if elements are strictly increasing and consecutive
                if (nums[j] - nums[j - 1] != 1) {
                    isConsecutive = false;
                    break;
                }
                maxElement = Math.max(maxElement, nums[j]);
            }
            
            if (isConsecutive) {
                results[i] = maxElement;
            } else {
                results[i] = -1;
            }
        }
        
        return results;
    }
}
