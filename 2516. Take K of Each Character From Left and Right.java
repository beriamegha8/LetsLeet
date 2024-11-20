class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int[] totalCount = new int[3];
        for (char c : s.toCharArray()) {
            totalCount[c - 'a']++;
        }
        if (totalCount[0] < k || totalCount[1] < k || totalCount[2] < k) {
            return -1;
        }
        int[] windowCount = new int[3];
        int minTime = n;
        for (int left = 0, right = 0; right < n; right++) {
            windowCount[s.charAt(right) - 'a']++;
            while (windowCount[0] > totalCount[0] - k || 
                   windowCount[1] > totalCount[1] - k || 
                   windowCount[2] > totalCount[2] - k) {
                windowCount[s.charAt(left) - 'a']--;
                left++;
            }
            
            minTime = Math.min(minTime, n - (right - left + 1));
        }
        
        return minTime;
    }
}
