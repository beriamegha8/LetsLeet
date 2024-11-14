class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = Arrays.stream(quantities).max().getAsInt();
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (canDistribute(n, quantities, mid)) {
                high = mid;  // Try to minimize further
            } else {
                low = mid + 1;  // Increase the possible max products per store
            }
        }
        
        return low;
    }
    
    private boolean canDistribute(int n, int[] quantities, int maxProducts) {
        int requiredStores = 0;
        
        for (int quantity : quantities) {
            requiredStores += (quantity + maxProducts - 1) / maxProducts;
            if (requiredStores > n) {
                return false;
            }
        }
        
        return true;
    }
}
