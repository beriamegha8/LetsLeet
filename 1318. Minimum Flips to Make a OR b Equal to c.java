class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        for (int i = 0; i < 32; i++) {
            // Extract the ith bits of a, b, and c
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;
            // Case when c[i] is 0: both a[i] and b[i] must be 0
            if (bitC == 0) {
                flips += bitA + bitB;
            }
            // Case when c[i] is 1: at least one of a[i] or b[i] must be 1
            else {
                if (bitA == 0 && bitB == 0) {
                    flips++; // flip one of them to 1
                }
            }
        }
        return flips;
    }
}
