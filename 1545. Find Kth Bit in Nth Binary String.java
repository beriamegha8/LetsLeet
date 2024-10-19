class Solution {
    public char findKthBit(int n, int k) {
        return findBit(n, k);
    }
    private char findBit(int n, int k) {
        if (n == 1) return '0';  // Base case: S1 = "0"
        int mid = (1 << (n - 1));  // mid = 2^(n-1)
        if (k == mid) {
            return '1';  // Middle bit is always '1'
        } else if (k < mid) {
            return findBit(n - 1, k);  // Left part, same as previous sequence
        } else {
            // Right part, mirrored and inverted
            char mirroredBit = findBit(n - 1, (1 << n) - k);
            return (mirroredBit == '0') ? '1' : '0';  // Invert the bit
        }
    }
}
