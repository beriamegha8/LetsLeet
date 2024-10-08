class Solution {
    public int minSwaps(String s) {
        int mismatches = 0;
        int openCount = 0;
        
        for (char bracket : s.toCharArray()) {
            if (bracket == '[') {
                openCount++;
            } else if (bracket == ']') {
                if (openCount > 0) {
                    openCount--;
                } else {
                    mismatches++;
                }
            }
        }
        
        return (mismatches + 1) / 2;
    }
}
