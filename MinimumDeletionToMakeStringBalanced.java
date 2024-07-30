class Solution {
    public int minimumDeletions(String s) {
        int b_count = 0;
        int min_del = 0;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                b_count++;
            } else {
                min_del = Math.min(min_del + 1, b_count);
            }
        }

        return min_del;
    }
}
