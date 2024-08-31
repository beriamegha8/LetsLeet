class Solution {
    public int generateKey(int num1, int num2, int num3) {
        String s1= String.format("%04d", num1);
        String s2= String.format("%04d", num2);
        String s3= String.format("%04d", num3);

        StringBuilder genkey= new StringBuilder();

        for (int i= 0; i<=3; i++){
            char min= (char)Math.min(Math.min(s1.charAt(i), s2.charAt(i)), s3.charAt(i));
            genkey.append(min);
        }
        return Integer.parseInt(genkey.toString());
    }
}
