class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] weakerTeamsCount = new int[n];
        for (int[] edge : edges) {
            int stronger = edge[0];
            int weaker = edge[1];
            weakerTeamsCount[weaker]++;
        }
        int championCount = 0;
        int champion = -1;
        
        for (int team = 0; team < n; team++) {
            if (weakerTeamsCount[team] == 0) {
                championCount++;
                champion = team;
                if (championCount > 1) {
                    return -1;
                }
            }
        }
        return champion;
    }
}
