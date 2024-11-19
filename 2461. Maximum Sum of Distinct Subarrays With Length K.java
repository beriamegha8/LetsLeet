import java.util.HashMap;  

class Solution {  
    public long maximumSubarraySum(int[] nums, int k) {  
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();  
        long currentSum = 0;  
        long maxSum = 0;  

        for (int i = 0; i < nums.length; i++) {  
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);  
            currentSum += nums[i];  

            if (i >= k - 1) {  
                if (frequencyMap.size() == k) {  
                    maxSum = Math.max(maxSum, currentSum);  
                }  

                // Remove the element that is sliding out of the window  
                int elementToRemove = nums[i - k + 1];  
                frequencyMap.put(elementToRemove, frequencyMap.get(elementToRemove) - 1);  
                if (frequencyMap.get(elementToRemove) == 0) {  
                    frequencyMap.remove(elementToRemove);  
                }  
                
                currentSum -= elementToRemove;  
            }  
        }  

        return maxSum == 0 ? 0 : maxSum;  
    }  
}
