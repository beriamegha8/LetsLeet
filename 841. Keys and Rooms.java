class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, 0, visited);
        for (boolean hasVisited : visited) {
            if (!hasVisited) {
                return false;
            }
        }
        return true;
    }
    private void dfs(List<List<Integer>> rooms, int currentRoom, boolean[] visited) {
        visited[currentRoom] = true;
        for (int key : rooms.get(currentRoom)) {
            if (!visited[key]) { 
                dfs(rooms, key, visited);
            }
        }
    }
}
