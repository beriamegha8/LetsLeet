class Solution {
    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        
        // Fill the maps with the stones' positions
        for (int[] stone : stones) {
            int x = stone[0];
            int y = stone[1];
            rowMap.putIfAbsent(x, new ArrayList<>());
            colMap.putIfAbsent(y, new ArrayList<>());
            rowMap.get(x).add(y);
            colMap.get(y).add(x);
        }
        
        boolean[] visited = new boolean[stones.length];
        int components = 0;
        
        for (int i = 0; i < stones.length; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, visited, stones, rowMap, colMap);
            }
        }
        
        return stones.length - components;
    }
    
    private void dfs(int index, boolean[] visited, int[][] stones, 
                     Map<Integer, List<Integer>> rowMap, Map<Integer, List<Integer>> colMap) {
        visited[index] = true;
        int x = stones[index][0];
        int y = stones[index][1];
        
        // Visit all stones in the same row
        for (int j : rowMap.get(x)) {
            for (int k = 0; k < stones.length; k++) {
                if (stones[k][1] == j && !visited[k]) {
                    dfs(k, visited, stones, rowMap, colMap);
                }
            }
        }
        
        // Visit all stones in the same column
        for (int j : colMap.get(y)) {
            for (int k = 0; k < stones.length; k++) {
                if (stones[k][0] == j && !visited[k]) {
                    dfs(k, visited, stones, rowMap, colMap);
                }
            }
        }
    }
}
