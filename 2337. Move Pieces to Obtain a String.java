class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0, j = 0;
        while (i < n || j < n) {
            while (i < n && start.charAt(i) == '_') i++;
            while (j < n && target.charAt(j) == '_') j++;
            if (i < n && j < n) {
                char sChar = start.charAt(i);
                char tChar = target.charAt(j);
                if (sChar != tChar) return false;
                if (sChar == 'L' && i < j) return false; // 'L' can't move right
                if (sChar == 'R' && i > j) return false; // 'R' can't move left
                i++;
                j++;
            } else {
                if (i < n || j < n) return false;
            }
        }
        return true;
    }
}
