class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int[] arr = nums.clone();
        int operations = 0;
        for (int i = 0; i < n - 2; i++) {
            if (arr[i] == 0) {
                // Flip the current and next two elements
                arr[i] ^= 1;
                arr[i + 1] ^= 1;
                arr[i + 2] ^= 1;
                operations++;
            }
        }
        
        // Check if the last two elements are 1
        if (arr[n - 2] == 0 || arr[n - 1] == 0) {
            return -1; // Impossible to make all elements 1
        }       
        return operations;
    }
}
