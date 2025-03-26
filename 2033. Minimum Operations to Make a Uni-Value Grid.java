class Solution {  
    public int minOperations(int[][] grid, int x) {  
        List<Integer> values= new ArrayList<>();  
        
        for (int[] row: grid) {  
            for (int value: row) {  
                values.add(value);  
            }  
        }  
        
        int min= Collections.min(values);  
        
        for (int value: values) {  
            if ((value- min) % x != 0) {  
                return -1; 
            }  
        }  
        
        Collections.sort(values);  
        int med= values.get(values.size() / 2);  
        
        int op = 0;  
        for (int value : values) {  
            op += Math.abs(value - med) / x;  
        }  
        
        return op;  
    }  
}  
