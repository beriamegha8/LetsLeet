class Solution {
    private int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
    
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        if (n <= 1) return true;
        
        // Create a sorted copy for comparison
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        
        // Keep track of segments with same bit count
        int i = 0;
        while (i < n) {
            int currentBits = countSetBits(nums[i]);
            int start = i;
            
            // Find end of current segment with same bit count
            while (i < n && countSetBits(nums[i]) == currentBits) {
                i++;
            }
            
            // Sort the current segment
            Arrays.sort(nums, start, i);
            
            // Compare with the sorted array
            for (int j = start; j < i; j++) {
                if (nums[j] != sorted[j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
