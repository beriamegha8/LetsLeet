class Solution {
    public double findMaxAverage(int[] nums, int k) {
        //sum of the first 'k' elements
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }
        
        int currentSum = maxSum;
        
        //sliding window approach
        for (int i = k; i < nums.length; i++) {
            //remove 1st element and add next element
            currentSum += nums[i] - nums[i - k];
            
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        
        return (double) maxSum / k;
    }
}
