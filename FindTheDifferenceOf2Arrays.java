class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Convert the arrays to sets to remove duplicates and allow set operations
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for (int num : nums1) {
            set1.add(num);
        }
        
        for (int num : nums2) {
            set2.add(num);
        }
        
        // Find elements in set1 that are not in set2
        List<Integer> answer1 = new ArrayList<>();
        for (int num : set1) {
            if (!set2.contains(num)) {
                answer1.add(num);
            }
        }
        
        // Find elements in set2 that are not in set1
        List<Integer> answer2 = new ArrayList<>();
        for (int num : set2) {
            if (!set1.contains(num)) {
                answer2.add(num);
            }
        }
        
        // Prepare the final answer
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(answer1);
        answer.add(answer2);
        
        return answer;
    }
}
