class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return s;
        }
        String revS = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < n; i++) {
            if (s.substring(0, n - i).equals(revS.substring(i))) {
                // Add the unmatched part of the reversed string to the front of the original string
                return revS.substring(0, i) + s;
            }
        }
        
        return "";
    }
}
