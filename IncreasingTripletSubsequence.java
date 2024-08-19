class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n= nums.length;

        if (n < 3) {
            return false;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        
        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                // If we find a number greater than both first and second, return true
                return true;
            }
        }
        
        return false;
    }
}
