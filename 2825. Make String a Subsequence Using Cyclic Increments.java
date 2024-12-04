class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0;
        int n1 = str1.length(), n2 = str2.length();
        while (i < n1 && j < n2) {
            char currentChar = str1.charAt(i);
            char targetChar = str2.charAt(j);
            char nextChar = (char) ((currentChar - 'a' + 1) % 26 + 'a');
            if (currentChar == targetChar || nextChar == targetChar) {
                j++;
            }
            i++;
        }
        return j == n2;
    }
}
