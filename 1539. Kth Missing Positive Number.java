class Solution {
    public int findKthPositive(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        int missingCount = 0;
        int current = 1;
        while (missingCount < k) {
            if (!set.contains(current)) {
                missingCount++;
                if (missingCount == k) {
                    return current;
                }
            }
            current++;
        }
        return -1;
    }
}
