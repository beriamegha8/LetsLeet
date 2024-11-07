class Solution {
    public int largestCombination(int[] candidates) {
        int maxCount = 0;
        // We'll use 24 bits since the maximum value of candidates[i] is 10^7
        int[] bitCount = new int[24];
        for (int num : candidates) {
            for (int i = 0; i < 24; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }
        for (int count : bitCount) {
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
