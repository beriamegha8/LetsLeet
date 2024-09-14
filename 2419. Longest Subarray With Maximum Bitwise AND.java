class Solution {
    public int longestSubarray(int[] nums) {
        //finding the maximum value in the array
        int maxVal = nums[0];
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        //calculating the longest subarray consisting of the maximum value
        int longest = 0;
        int currentLength = 0;
        for (int num : nums) {
            if (num == maxVal) {
                currentLength++; // Continue the subarray
                longest = Math.max(longest, currentLength); // Track the maximum length
            } else {
                currentLength = 0; //reset on value unmatching
            }
        }
        
        return longest;
    }
}
