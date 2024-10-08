class Solution {
    public void sortColors(int[] nums) {
        int zeros = 0;
        int ones = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeros++;
            if (nums[i] == 1)
                ones++;
        }
        for (int i = 0; i < zeros; i++) {
            nums[i] = 0;
        }
        for (int i = zeros; i < ones + zeros; i++) {
            nums[i] = 1;
        }
        for (int i = ones + zeros; i < nums.length; i++) {
            nums[i] = 2;
        }
    }

}
