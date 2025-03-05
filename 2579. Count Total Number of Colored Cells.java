class Solution {  
    public long coloredCells(int n) {  
        long total= 1; 
        long ext= 0;  

        for (int i = 1; i < n; i++) {  
            ext+= 4;
            total+= ext; 
        }  

        return total;  
    }  
}  
