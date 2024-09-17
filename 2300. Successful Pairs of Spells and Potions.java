import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            result[i] = countValidPotions(spells[i], potions, success);
        }
        return result;
    }
    private int countValidPotions(int spell, int[] potions, long success) {
        long minPotionStrength = (success + spell - 1) / spell;
        int left = 0, right = potions.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] >= minPotionStrength) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return potions.length - left; // Number of valid potions
    }
}
