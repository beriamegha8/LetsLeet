import java.util.Arrays;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        int[][] starts = new int[n][2]; 
        
        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }
        
        Arrays.sort(starts, (a, b) -> Integer.compare(a[0], b[0]));
        
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            int idx = binarySearch(starts, end);
            
            result[i] = (idx == n) ? -1 : starts[idx][1];
        }
        
        return result;
    }
    
    // Binary search to find the smallest start that is >= end
    private int binarySearch(int[][] starts, int end) {
        int low = 0, high = starts.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (starts[mid][0] >= end) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
