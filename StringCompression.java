public class Solution {  
    public int compress(char[] chars) {  
        int write = 0;  
        int start = 0;  

        while (start < chars.length) {  
            int end = start;  
            
            while (end < chars.length && chars[end] == chars[start]) {  
                end++;  
            }  

            chars[write++] = chars[start];  

            int count = end - start;  
            if (count > 1) {  
                String countStr = String.valueOf(count);  
                for (char c : countStr.toCharArray()) {  
                    chars[write++] = c;  
                }  
            }  

            start = end;  
        }  

        return write;  
    }  
}
