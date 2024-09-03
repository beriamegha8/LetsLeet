class Solution {
    public int getLucky(String s, int k) {
        StringBuilder numStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            int value = c - 'a' + 1; //position of alphabet
            numStr.append(value);
        }
        //sum of digits transformation
        String transformed = numStr.toString();
        while (k-- > 0) {
            int sum = 0;
            for (char digit : transformed.toCharArray()) {
                sum += digit - '0'; //converting character to digit and add to sum
            }
            transformed = String.valueOf(sum);
        }
        return Integer.parseInt(transformed);
    }
}
