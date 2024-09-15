class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Integer, Integer> firstOccurrence = new HashMap<>();
        // Initial condition: bitmask 0 occurs at index -1
        firstOccurrence.put(0, -1);
        int bitmask = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // Update the bitmask for vowels
            switch (ch) {
                case 'a': bitmask ^= 1 << 0; break; // Toggle the 0th bit for 'a'
                case 'e': bitmask ^= 1 << 1; break; // Toggle the 1st bit for 'e'
                case 'i': bitmask ^= 1 << 2; break; // Toggle the 2nd bit for 'i'
                case 'o': bitmask ^= 1 << 3; break; // Toggle the 3rd bit for 'o'
                case 'u': bitmask ^= 1 << 4; break; // Toggle the 4th bit for 'u'
            }
            if (firstOccurrence.containsKey(bitmask)) {
                maxLength = Math.max(maxLength, i - firstOccurrence.get(bitmask));
            } else {
                firstOccurrence.put(bitmask, i);
            }
        }
        return maxLength;
    }
}
