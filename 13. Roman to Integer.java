class Solution {
    public int romanToInt(String s) {
        char[] charArray = s.toCharArray();
        int num = 0;

        for (int i = 0; i < charArray.length; i++) {
            // Check if the current character is smaller than the next one, indicating a subtraction case
            if (i < charArray.length - 1 && getValue(charArray[i]) < getValue(charArray[i + 1])) {
                num -= getValue(charArray[i]);
            } else {
                num += getValue(charArray[i]);
            }
        }

        return num;
    }

    // Helper function to map Roman numerals to their integer values
    private int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
