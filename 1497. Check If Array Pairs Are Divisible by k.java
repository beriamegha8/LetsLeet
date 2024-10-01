class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] remainderCount = new int[k];
        for (int num : arr) {
            int remainder = ((num % k) + k) % k;
            remainderCount[remainder]++;
        }
        for (int i = 1; i < k; i++) {
            // Remainders i and k - i must have the same frequency
            if (remainderCount[i] != remainderCount[k - i]) {
                return false;
            }
        }
        //numbers divisible by k must pair with themselves
        return remainderCount[0] % 2 == 0;
    }
}
