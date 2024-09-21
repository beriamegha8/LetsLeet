class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry == 1) {
            int bitA = (i >= 0) ? a.charAt(i) - '0' : 0;
            int bitB = (j >= 0) ? b.charAt(j) - '0' : 0;
            int sum = bitA + bitB + carry;
            if (sum == 0) {
                result.append('0');
                carry = 0;
            } else if (sum == 1) {
                result.append('1');
                carry = 0;
            } else if (sum == 2) {
                result.append('0');
                carry = 1;
            } else {  // sum == 3 (1 + 1 + 1 = 11)
                result.append('1');
                carry = 1;
            }
            i--;
            j--;
        }
        return result.reverse().toString();
    }
}