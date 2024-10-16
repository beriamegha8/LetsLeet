class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder result = new StringBuilder();
        int[] counts = {a, b, c};
        char[] chars = {'a', 'b', 'c'};

        while (true) {
            // Step 1: Sort counts and characters by frequency (descending order).
            if (counts[0] < counts[1]) swap(counts, chars, 0, 1);
            if (counts[1] < counts[2]) swap(counts, chars, 1, 2);
            if (counts[0] < counts[1]) swap(counts, chars, 0, 1);

            // Step 2: Add the most frequent character if it doesn't cause "aaa", "bbb", or "ccc".
            if (counts[0] == 0) break;  // No more characters left to add.

            int len = result.length();
            if (len >= 2 && result.charAt(len - 1) == chars[0] && result.charAt(len - 2) == chars[0]) {
                // If the top character causes three consecutive identical letters, try the next character.
                if (counts[1] == 0) break;  // No valid characters left to add.
                result.append(chars[1]);
                counts[1]--;
            } else {
                // Add the most frequent character.
                result.append(chars[0]);
                counts[0]--;
            }
        }

        return result.toString();
    }

    // Helper function to swap counts and characters.
    private void swap(int[] counts, char[] chars, int i, int j) {
        int tempCount = counts[i];
        counts[i] = counts[j];
        counts[j] = tempCount;

        char tempChar = chars[i];
        chars[i] = chars[j];
        chars[j] = tempChar;
    }
}
