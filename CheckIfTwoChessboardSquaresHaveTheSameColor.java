class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int c1= coordinate1.charAt(0) - 'a';
        int r1= coordinate1.charAt(1) - '1';
        int c2= coordinate2.charAt(0) - 'a';
        int r2= coordinate2.charAt(1) - '1';

        return (c1+r1)%2 == (c2+r2)%2;
    }
}
