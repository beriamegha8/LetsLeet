class Solution {
    public int maximumCount(int[] nums) {
        int neg = binarySearch(nums, 0);
        int pos = nums.length - binarySearch(nums, 1);
        return Math.max(neg, pos);
    }
    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
