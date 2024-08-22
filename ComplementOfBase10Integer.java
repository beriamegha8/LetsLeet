class Solution {
    public int bitwiseComplement(int n) {
        // Length of binary representation  
        int numBits = Integer.toBinaryString(n).length();  
        
        // Create a mask of 'numBits' where all bits are 1s  
        int mask = (1 << numBits) - 1;  
        
        // The complement is simply the XOR of num and the mask  
        return n ^ mask; 
    }
}
