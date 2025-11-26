class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int MOD = 1000000007;

        int[][] prev = new int[grid[0].length][k];

        int initalMod = grid[0][0] % k;
        prev[0][initalMod] = 1;

        for (int j = 1; j < grid[0].length; j++) {
            for (int m = 0; m < k; m++) {
                int newMod = (m + grid[0][j]) % k;
                prev[j][newMod] += prev[j - 1][m];
            }
        }

        for (int i = 1; i < grid.length; i++) {
            int[][] curr = new int[grid[0].length][k];
            for (int j = 0; j < grid[0].length; j++) {
                for (int m = 0; m < k; m++) {
                    int newMod = (grid[i][j] + m) % k;

                    if (j > 0) {
                        curr[j][newMod] = (curr[j][newMod] + curr[j-1][m]) % MOD;
                    }
                    if (i > 0) {
                        curr[j][newMod] = (curr[j][newMod] + prev[j][m]) % MOD;
                    }
                }
            }
            prev = curr;
        }
        return prev[grid[0].length - 1][0];
    }
}