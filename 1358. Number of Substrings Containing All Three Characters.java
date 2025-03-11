class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3]; // Count of 'a', 'b', and 'c'
        int left = 0, total = 0;
        
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'a']++; // Include character in window
            
            // Move left pointer to make window minimal but still valid
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                total += s.length() - right; // All substrings ending from right to end are valid
                count[s.charAt(left) - 'a']--; // Shrink window
                left++;
            }
        }
        return total;
    }
}
