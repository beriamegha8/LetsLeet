class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0){
            return 0;
        }
        int i= 0;
         for (int j= 0; j< nums.length; j++){
            if (nums[j] != val){
                nums[i]= nums[j]; //considering the elements only that are not equal to the val
                i++;
            }
         }
         return i;
    }
}
