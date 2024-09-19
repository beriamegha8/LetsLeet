class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;  // Minimum possible speed
        int right = getMaxPile(piles);  // Maximum possible speed (largest pile size)
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private boolean canFinish(int[] piles, int k, int h) {
        int hoursSpent = 0;
        for (int pile : piles) {
            hoursSpent += (pile + k - 1) / k;
        }
        return hoursSpent <= h;
    }
    
    private int getMaxPile(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}
