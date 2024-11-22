class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patternCount = new HashMap<>();
        int maxEqualRows = 0;
        for (int[] row : matrix) {
            // Create two possible patterns for each row
            StringBuilder pattern1 = new StringBuilder();
            StringBuilder pattern2 = new StringBuilder();
            
            for (int val : row) {
                pattern1.append(val);
                pattern2.append(1 - val);  // Flipped pattern
            }
            
            // Use lexicographically smaller pattern to count
            String canonicalPattern = pattern1.toString().compareTo(pattern2.toString()) <= 0 
                ? pattern1.toString() 
                : pattern2.toString();
            int count = patternCount.getOrDefault(canonicalPattern, 0) + 1;
            patternCount.put(canonicalPattern, count);
            maxEqualRows = Math.max(maxEqualRows, count);
        }
        
        return maxEqualRows;
    }
}
