public class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        
        for (int num : nums) {
            // Update ones and twos with the new num
            // using XOR we confirm the presence in the array but not in ones or twos respectively
            // using negation we ensure it isnt in both the conditions
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        
        return ones;
    }
}
