class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int targetRemainder = (int) (totalSum % p);
        if (targetRemainder == 0) return 0;

        Map<Integer, Integer> lastSeen = new HashMap<>();
        lastSeen.put(0, -1);
        int currSum = 0;
        int minLength = n;
        
        for (int i = 0; i < n; i++) {
            currSum = (currSum + nums[i]) % p;
            int complement = (currSum - targetRemainder + p) % p;
            
            if (lastSeen.containsKey(complement)) {
                minLength = Math.min(minLength, i - lastSeen.get(complement));
            }
            
            lastSeen.put(currSum, i);
        }
        return minLength < n ? minLength : -1;
    }
}
