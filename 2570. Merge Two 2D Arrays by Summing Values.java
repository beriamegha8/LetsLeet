import java.util.*;  
class Solution {  
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {  
        Map<Integer, Integer> map = new HashMap<>();  //storing sum for each id
        for (int[] entry : nums1) {  
            map.put(entry[0], map.getOrDefault(entry[0], 0) + entry[1]);  
        }  
        for (int[] entry : nums2) {  
            map.put(entry[0], map.getOrDefault(entry[0], 0) + entry[1]);  
        }  
        List<int[]> result = new ArrayList<>();  

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {  
            result.add(new int[]{entry.getKey(), entry.getValue()});  
        }  

        //sorting the list
        Collections.sort(result, Comparator.comparingInt(a -> a[0]));  
        
        //converting into 2d array
        return result.toArray(new int[result.size()][]);  
    }  
}  
