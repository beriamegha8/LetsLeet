class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrenceMap = new HashMap<>();
        for (int num : arr) {
            occurrenceMap.put(num, occurrenceMap.getOrDefault(num, 0) + 1);
        }
        
        Set<Integer> occurrencesSet = new HashSet<>();
        for (int count : occurrenceMap.values()) {
            if (!occurrencesSet.add(count)) {
                //since HashSet contains all unique values, if the new count is not being added it means the same count already exists, in that case it is not a unique count
                return false;
            }
        }
        
        return true;
    }
}
