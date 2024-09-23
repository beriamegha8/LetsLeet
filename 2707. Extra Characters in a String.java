import java.util.Arrays;

class Solution {
    public int numSubseq(int[] nums, int target) {
        int MOD = 1_000_000_007;
        int n = nums.length;
        
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        // Step 2: Precompute powers of 2 up to n
        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % MOD;
        }
        
        int left = 0, right = n - 1;
        int result = 0;
        
        // Step 3: Use two pointers to count valid subsequences
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                // Count all subsequences between left and right
                result = (result + pow[right - left]) % MOD;
                left++;  // Move left pointer to explore more subsequences
            } else {
                right--;  // Move right pointer to reduce the sum
            }
        }
        
        return result;
    }
}
