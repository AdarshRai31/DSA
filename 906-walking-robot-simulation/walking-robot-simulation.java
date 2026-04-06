class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // 1. Directions: North, East, South, West
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // 2. Store obstacles in a Set for O(1) lookup
        // We use a string or a custom hash to represent coordinates
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }
        
        int x = 0, y = 0;
        int directionIndex = 0; // Starts facing North
        int maxDistSq = 0;
        
        for (int cmd : commands) {
            if (cmd == -1) { // Turn Right
                directionIndex = (directionIndex + 1) % 4;
            } else if (cmd == -2) { // Turn Left
                directionIndex = (directionIndex + 3) % 4;
            } else {
                // Move forward 'cmd' steps
                for (int i = 0; i < cmd; i++) {
                    int nextX = x + dirs[directionIndex][0];
                    int nextY = y + dirs[directionIndex][1];
                    
                    // Check if next step is an obstacle
                    if (!obstacleSet.contains(nextX + "," + nextY)) {
                        x = nextX;
                        y = nextY;
                        // Update max distance squared reached at any point
                        maxDistSq = Math.max(maxDistSq, x * x + y * y);
                    } else {
                        // Hit an obstacle, stop moving for this command
                        break;
                    }
                }
            }
        }
        
        return maxDistSq;
    }
}