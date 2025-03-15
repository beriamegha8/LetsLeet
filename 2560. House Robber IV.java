class Solution {
    public int minCapability(int[] nums, int k) {
        int left = 1; 
        int right = 1_000_000_000;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            //mid= capability
            if (canRobKHouses(nums, k, mid)) {
                // If yes, try to find a smaller capability
                right = mid;
            } else {
                // If no, we need a larger capability
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    // Helper function to check if we can rob at least k houses
    // with the given capability
    private boolean canRobKHouses(int[] nums, int k, int capability) {
        int count = 0;
        int i = 0;
        
        while (i < nums.length) {
            // If we can rob this house (value <= capability)
            if (nums[i] <= capability) {
                count++;
                i += 2;  // Skip the next house (adjacent)
            } else {
                i++;  // Move to next house
            }
        }
        
        return count >= k;
    }
}
