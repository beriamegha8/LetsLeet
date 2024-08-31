import java.util.HashSet;
import java.util.Set;

public class Solution {

    private int[] factorials;

    public Solution() {
        factorials = new int[11];
        factorials[0] = 1;
        for (int i = 1; i < 11; i++) {
            factorials[i] = factorials[i - 1] * i;
        }
    }

    public int countGoodIntegers(int numDigits, int divisor) {
        Set<String> digitCountSets = new HashSet<>();
        int halfLength = (numDigits + 1) / 2;
        long minValue = (long) Math.pow(10, halfLength - 1);
        long maxValue = (long) Math.pow(10, halfLength) - 1;

        if (numDigits == 1) {
            minValue = 0;
        }

        for (long firstHalf = minValue; firstHalf <= maxValue; firstHalf++) {
            String palindrome = createPalindrome(firstHalf, numDigits);
            if (palindrome.length() == numDigits && Long.parseLong(palindrome) % divisor == 0) {
                int[] digitCounts = computeDigitCounts(palindrome, numDigits);
                digitCountSets.add(encodeDigitCounts(digitCounts));
            }
        }

        return computePermutations(digitCountSets, numDigits);
    }

    private String createPalindrome(long firstHalf, int numDigits) {
        String halfStr = String.valueOf(firstHalf);
        if (numDigits % 2 == 0) {
            return halfStr + new StringBuilder(halfStr).reverse().toString();
        } else {
            return halfStr + new StringBuilder(halfStr.substring(0, halfStr.length() - 1)).reverse().toString();
        }
    }

    private int[] computeDigitCounts(String numberStr, int numDigits) {
        int[] counts = new int[10];
        while (numberStr.length() < numDigits) {
            numberStr = "0" + numberStr;
        }
        for (char ch : numberStr.toCharArray()) {
            counts[ch - '0']++;
        }
        return counts;
    }

    private String encodeDigitCounts(int[] counts) {
        StringBuilder encoded = new StringBuilder();
        for (int count : counts) {
            encoded.append(count).append(",");
        }
        return encoded.toString();
    }

    private int computePermutations(Set<String> digitCountSets, int numDigits) {
        int totalPermutations = 0;
        for (String encodedCounts : digitCountSets) {
            int[] counts = decodeDigitCounts(encodedCounts);
            int permutations = 0;
            for (int digit = 1; digit < 10; digit++) {
                if (counts[digit] == 0) {
                    continue;
                }
                int[] adjustedCounts = counts.clone();
                adjustedCounts[digit]--;
                if (anyNegative(adjustedCounts)) {
                    continue;
                }
                int arrangementCount = factorials[numDigits - 1];
                for (int count : adjustedCounts) {
                    arrangementCount /= factorials[count];
                }
                permutations += arrangementCount;
            }
            totalPermutations += permutations;
        }
        return totalPermutations;
    }

    private int[] decodeDigitCounts(String encodedCounts) {
        String[] parts = encodedCounts.split(",");
        int[] counts = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            counts[i] = Integer.parseInt(parts[i]);
        }
        return counts;
    }

    private boolean anyNegative(int[] counts) {
        for (int count : counts) {
            if (count < 0) {
                return true;
            }
        }
        return false;
    }
}
