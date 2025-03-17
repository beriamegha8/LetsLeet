class Solution {
    public boolean divideArray(int[] nums) {
        // Since the constraint says nums[i] <= 500
        int[] frequency = new int[501];
        for (int num : nums) {
            frequency[num]++;
        }
        for (int count : frequency) {
            if (count % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
