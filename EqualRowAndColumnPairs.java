import java.util.*;

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;

        //a map to store the frequency of each row as a List<Integer>
        Map<List<Integer>, Integer> rowMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                rowList.add(grid[i][j]);
            }
            rowMap.put(rowList, rowMap.getOrDefault(rowList, 0) + 1);
        }
        
        //checking columns
        for (int j = 0; j < n; j++) {
            List<Integer> colList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                colList.add(grid[i][j]);
            }
            count += rowMap.getOrDefault(colList, 0);
        }
        
        return count;
    }
}
