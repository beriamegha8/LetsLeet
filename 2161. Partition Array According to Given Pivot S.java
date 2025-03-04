class Solution {  
    public int[] pivotArray(int[] nums, int pivot) {  
        List<Integer> lessThan = new ArrayList<>();  
        List<Integer> equalTo = new ArrayList<>();  
        List<Integer> greaterThan = new ArrayList<>();  
        
        for (int num : nums) {  
            if (num < pivot) {  
                lessThan.add(num);  
            } else if (num == pivot) {  
                equalTo.add(num);  
            } else {  
                greaterThan.add(num);  
            }  
        }  

        int[] result = new int[nums.length];  
        int index = 0;  

        for (int num : lessThan) {  
            result[index++] = num;  
        }  

        for (int num : equalTo) {  
            result[index++] = num;  
        }  

        for (int num : greaterThan) {  
            result[index++] = num;  
        }  

        return result;
    }  
}  
