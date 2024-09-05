import java.util.Arrays;

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int totalSum = (n + m) * mean;
        int sumOfKnownRolls = Arrays.stream(rolls).sum();
        int sumOfMissingRolls = totalSum - sumOfKnownRolls;
        if (sumOfMissingRolls < n || sumOfMissingRolls > 6 * n) {
            return new int[0];
        }
        
        //Distribute the sum of missing rolls
        int[] missingRolls = new int[n];
        Arrays.fill(missingRolls, 1);  // Start by giving each roll the minimum value
        sumOfMissingRolls -= n;  // Since we assigned 1 to each roll, subtract n from the sum
        // Distribute the remaining sum across the missing rolls
        for (int i = 0; i < n && sumOfMissingRolls > 0; i++) {
            int add = Math.min(5, sumOfMissingRolls);  // We can add up to 5 to each roll (1 + 5 = 6)
            missingRolls[i] += add;
            sumOfMissingRolls -= add;
        }
        return missingRolls;
    }
}
