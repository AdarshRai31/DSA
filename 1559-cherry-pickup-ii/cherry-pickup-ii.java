class Solution {
    public static int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] front = new int[m][m];

        for (int j1 = 0; j1 < grid[0].length; j1++) {
            for (int j2 = 0; j2 < grid[0].length; j2++) {
                if (j1 == j2) {
                    front[j1][j2] = grid[n - 1][j1];
                }
                else {
                    front[j1][j2] = grid[n-1][j1] + grid[n-1][j2];
                }
            }
        }

        for (int i = n-2; i >= 0; i--) {
            int[][] curr = new  int[m][m];
            for (int j1 = 0; j1 < grid[0].length; j1++) {
                for (int j2 = 0; j2 < grid[0].length; j2++) {
                    int max = Integer.MIN_VALUE;
                    for (int ii = -1; ii < 2; ii++) {
                        for (int j = -1; j < 2; j++) {
                            int value = 0;
                            if (j1 == j2) {
                                value = grid[i][j1];
                            }
                            else {
                                value = grid[i][j1] + grid[i][j2];
                            }
                            if (j1 + ii >= 0 && j2 + j >= 0 && j1 + ii < grid[0].length && j2 + j < grid[0].length) {
                                max = Math.max(max, value + front[j1 + ii][j2 + j]);
                            }
                        }
                    }
                    curr[j1][j2] = max;
                }
            }
            front = curr;
        }
        return front[0][grid[0].length - 1];
    }
}