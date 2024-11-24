class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0; 
        int negativeCount = 0; 
        int minAbs = Integer.MAX_VALUE; 
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                totalSum += Math.abs(value);
                if (value < 0) {
                    negativeCount++;
                }
                minAbs = Math.min(minAbs, Math.abs(value));
            }
        }
        
        if (negativeCount % 2 != 0) {
            totalSum -= 2 * minAbs;
        }
        
        return totalSum;
    }
}
