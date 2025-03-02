class Solution {  
    public int[] applyOperations(int[] nums) {  
        int n = nums.length;  
        //apply op on array
        for (int i = 0; i < n - 1; i++) {  
            if (nums[i] == nums[i + 1]) {  
                nums[i] *= 2;  
                nums[i + 1] = 0;  
            }  
        }  

        //move to non zero in the start
        int[] result = new int[n];  
        int index = 0;  

        //add non-zero to result  
        for (int num : nums) {  
            if (num != 0) {  
                result[index++] = num;  
            }  
        }  

        // Fill the rest of result with zeros  
        while (index < n) {  
            result[index++] = 0;  
        }  

        return result;  
    }  
}  
