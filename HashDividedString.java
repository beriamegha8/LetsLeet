class Solution {
    public String stringHash(String s, int k) {
        int n = s.length();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < n; i += k) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += s.charAt(j) - 'a';
            }
            char hashedChar = (char) ('a' + (sum % 26));
            result.append(hashedChar);
        }
        return result.toString();
    }
}
