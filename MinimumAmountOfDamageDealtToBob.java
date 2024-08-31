import java.util.*;

class Solution {
    public long minDamage(int power, int[] damage, int[] health) {
        int n = damage.length;
        List<int[]> enemies = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            enemies.add(new int[]{damage[i], health[i]});
        }

        Collections.sort(enemies, (a, b) -> {
            long valueA = (long) a[0] * ((b[1] + power - 1) / power);
            long valueB = (long) b[0] * ((a[1] + power - 1) / power);
            return Long.compare(valueB, valueA);
        });

        long totalDamage = 0;
        long currentDamage = 0;

        for (int[] enemy : enemies) {
            currentDamage += enemy[0];
        }
        for (int[] enemy : enemies) {
            int hits = (enemy[1] + power - 1) / power;
            totalDamage += hits * currentDamage;
            currentDamage -= enemy[0];
        }

        return totalDamage;
    }
}
