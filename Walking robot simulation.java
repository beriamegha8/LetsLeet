import java.util.HashSet;
import java.util.Set;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Directions: north, east, south, west
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        // Convert obstacles array to a Set for fast lookup
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }
        
        int x = 0, y = 0, dir = 0;
        int maxDistanceSq = 0;
        
        for (int command : commands) {
            if (command == -2) {       // turn left
                dir = (dir + 3) % 4;
            } else if (command == -1) { // turn right
                dir = (dir + 1) % 4;
            } else { // move forward
                for (int i = 0; i < command; i++) {
                    int nextX = x + dx[dir];
                    int nextY = y + dy[dir];
                    
                    // Check if the next step hits an obstacle
                    if (!obstacleSet.contains(nextX + "," + nextY)) {
                        x = nextX;
                        y = nextY;
                        maxDistanceSq = Math.max(maxDistanceSq, x * x + y * y);
                    } else {
                        break; // stop if there's an obstacle
                    }
                }
            }
        }
        
        return maxDistanceSq;
    }
}
