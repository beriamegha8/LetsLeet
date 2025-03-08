class Solution {  
    public int minimumRecolors(String blocks, int k) {  
        int n= blocks.length();  
        int minRe= Integer.MAX_VALUE;  
        for(int i= 0; i<= n-k; i++) {  
            String sliWin= blocks.substring(i, i+k);  
            int rec= 0;  
            for(int j= 0; j<k; j++) {  
                if (sliWin.charAt(j)== 'W') {  
                    rec++;  
                }  
            }  
            minRe= Math.min(minRe, rec);  
        }  
        return minRe;  
    }  
}  
