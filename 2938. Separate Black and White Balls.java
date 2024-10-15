class Solution {
    public long minimumSteps(String s) {
        long steps = 0;
        long countOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                countOnes++;
            } else {
                steps += countOnes;
            }
        }
        return steps;
    }
}
