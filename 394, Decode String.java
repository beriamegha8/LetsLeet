class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int k = 0;
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(k);
                strStack.push(currStr);
                // Reset for the next part of the string
                currStr = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                // Pop the stack to get the last number and string
                int repeatTimes = numStack.pop();
                StringBuilder decodedStr = strStack.pop();
                // Repeat the current string repeatTimes and append to decodedStr
                for (int i = 0; i < repeatTimes; i++) {
                    decodedStr.append(currStr);
                }
                currStr = decodedStr;
            } else {
                // If it's a letter, add it to the current string
                currStr.append(c);
            }
        }
        // Character array to str
        return currStr.toString();
    }
}
