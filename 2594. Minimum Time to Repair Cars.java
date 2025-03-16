class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 0;
        long right = (long) 1e14;
        
        // Binary search for the minimum time
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canRepairAllCars(ranks, cars, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canRepairAllCars(int[] ranks, int cars, long time) {
        long tot = 0;
        for (int rank : ranks) {
            long carRep = (long) Math.sqrt(time / rank);
            tot += carRep;
            if (tot >= cars) {
                return true;
            }
        }
        return false;
    }
}
