import java.util.*;

class Solution {
    public int slidingPuzzle(int[][] board) {
        // Convert board to a string for easier manipulation
        StringBuilder start = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                start.append(num);
            }
        }
        String target = "123450";
        if (start.toString().equals(target))
            return 0;
        // Valid swaps for each index in the flattened board
        int[][] moves = {
            {1, 3},
            {0, 2, 4},
            {1, 5},
            {0, 4},
            {1, 3, 5},
            {2, 4}
        };
        
        // BFS initialization
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start.toString());
        visited.add(start.toString());
        
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) {
                    return steps;
                }
                
                int zeroIndex = current.indexOf('0');
                for (int swapIndex : moves[zeroIndex]) {
                    String next = swap(current, zeroIndex, swapIndex);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    
    private String swap(String state, int i, int j) {
        char[] arr = state.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}
