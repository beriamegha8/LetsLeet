class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int n = digits.length;

        int maxIdx = n - 1;
        int swapLeft = -1, swapRight = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (digits[i] > digits[maxIdx]) {
                maxIdx = i;  // Update maxIdx if we find a larger digit
            } else if (digits[i] < digits[maxIdx]) {
                // If a smaller digit is found, record swap indices
                swapLeft = i;
                swapRight = maxIdx;
            }
        }
        if (swapLeft != -1) {
            char temp = digits[swapLeft];
            digits[swapLeft] = digits[swapRight];
            digits[swapRight] = temp;
        }
        return Integer.parseInt(new String(digits));
    }
}
