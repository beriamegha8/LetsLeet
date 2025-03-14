class Solution {
    public int maximumCandies(int[] candies, long k) {
        if (candies.length == 0 || k == 0) return 0;
        long totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }
        if (totalCandies < k) return 0;
        int left = 1;  // Minimum possible allocation
        int right = (int)Math.min((long)Integer.MAX_VALUE, totalCandies / k);  // Maximum possible allocation
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            
            if (canAllocate(candies, k, mid)) {
                left = mid; 
            } else {
                right = mid - 1; 
            }
        }
        return left;
    }
    
    // Helper function to check if we can allocate 'candiesPerChild' to 'k' children
    private boolean canAllocate(int[] candies, long k, int candiesPerChild) {
        long childrenCount = 0;
        for (int pile : candies) {
            childrenCount += pile / candiesPerChild; 
            if (childrenCount >= k) {
                return true;  
            }
        }
        return false; 
    }
}
