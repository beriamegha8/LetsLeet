class Solution {
    public int minBitFlips(int start, int goal) {
        // XOR start and goal to find where the bits differ
        int xor = start ^ goal;
        
        // Count the number of 1s in the binary representation of xor
        int count = 0;
        while (xor != 0) {
            // Check if the last bit is 1
            count += xor & 1;
            // Right shift
            xor >>= 1;
        }
        
        return count;
    }
}
