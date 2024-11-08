class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] answer = new int[n];
        int xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
        }
        // Mask with all bits set to 1 up to maximumBit
        int mask = (1 << maximumBit) - 1;
        for (int i = 0; i < n; i++) {
            // answer[i] is the XOR of xorSum with the mask
            answer[i] = xorSum ^ mask;
            xorSum ^= nums[n - 1 - i];
        }
        return answer;
    }
}
