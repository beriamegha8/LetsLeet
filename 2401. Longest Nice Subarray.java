class Solution {
    public int longestNiceSubarray(int[] nums) {
        int maxLength = 1; 
        int usedBits = 0;  
        int left = 0;     
        for (int right = 0; right < nums.length; right++) {
            while ((usedBits & nums[right]) != 0) {
                usedBits ^= nums[left];
                left++;
            }
            // Include the current number in our window
            usedBits |= nums[right];
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
