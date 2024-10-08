class Solution {
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length - 1;
        int n = citations.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= n - mid) {
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }
        
        return n - left; // left is the first index where citations[left] >= n - left
    }
}
