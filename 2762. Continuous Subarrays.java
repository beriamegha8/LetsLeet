class Solution {
    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        int l = 0;
        long count = 0;
        for (int r = 0; r < nums.length; r++) {
            freqMap.put(nums[r], freqMap.getOrDefault(nums[r], 0) + 1);
            while (freqMap.lastKey() - freqMap.firstKey() > 2) {
                freqMap.put(nums[l], freqMap.get(nums[l]) - 1);
                if (freqMap.get(nums[l]) == 0) {
                    freqMap.remove(nums[l]);
                }
                l++;
            }
            count += (r - l + 1);
        }
        return count;
    }
}
