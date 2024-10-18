class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int maxOr = 0;

        // Step 1: Find the maximum possible bitwise OR for the entire set.
        for (int num : nums) {
            maxOr |= num;
        }

        return backtrack(nums, 0, 0, maxOr);
    }

    private int backtrack(int[] nums, int index, int currentOr, int targetOr) {
        // If we've processed all elements, check if the OR matches the target.
        if (index == nums.length) {
            return currentOr == targetOr ? 1 : 0;
        }
        int include = backtrack(nums, index + 1, currentOr | nums[index], targetOr);
        int exclude = backtrack(nums, index + 1, currentOr, targetOr);
        return include + exclude;
    }
}
