class Solution {
    public int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }
    // Backtracking function to explore all possible splits
    private int backtrack(String s, int start, HashSet<String> seen) {
        // Base case: If we reach the end of the string, return 0
        if (start == s.length()) {
            return 0;
        }
        int maxSplits = 0;
        // Try splitting the string at all possible positions
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            // If the substring is unique, add it to the set and recurse
            if (!seen.contains(substring)) {
                seen.add(substring);
                // Recursively explore the rest of the string
                maxSplits = Math.max(maxSplits, 1 + backtrack(s, end, seen));
                // Backtrack by removing the substring from the set
                seen.remove(substring);
            }
        }
        return maxSplits;
    }
}
