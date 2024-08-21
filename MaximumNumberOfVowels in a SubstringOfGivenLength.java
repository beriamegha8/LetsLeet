class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        int maxVowels = 0, currentVowels = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                currentVowels++;
            }
        }
        maxVowels = currentVowels;

        //sliding window approach
        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i - k))) {
                currentVowels--;
            }
            if (vowels.contains(s.charAt(i))) {
                currentVowels++;
            }
            maxVowels = Math.max(maxVowels, currentVowels);
        }

        return maxVowels;
    }
}
