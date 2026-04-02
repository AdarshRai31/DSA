class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        int[][][] dp = new int[m][n][3];
        // Use a safe negative infinity that won't overflow
        int INF = (int)1e9; 

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= 2; k++) {
                    if (i == 0 && j == 0) {
                        dp[0][0][0] = coins[0][0];
                        dp[0][0][1] = (coins[0][0] < 0) ? 0 : -INF;
                        dp[0][0][2] = -INF;
                        continue;
                    }

                    int left = -INF;
                    int top = -INF;

                    if (i > 0) top = dp[i-1][j][k];
                    if (j > 0) left = dp[i][j-1][k];
                    
                    // Option 1: Take the current coin
                    int prevBest = Math.max(top, left);
                    if (prevBest <= -INF) {
                        dp[i][j][k] = -INF; 
                    } else {
                        dp[i][j][k] = prevBest + coins[i][j];
                    }

                    // Option 2: Neutralize the current coin
                    if (k > 0 && coins[i][j] < 0) {
                        int prevLeftK = (j > 0) ? dp[i][j-1][k-1] : -INF;
                        int prevTopK = (i > 0) ? dp[i-1][j][k-1] : -INF;
                        dp[i][j][k] = Math.max(dp[i][j][k], Math.max(prevLeftK, prevTopK));
                    }
                }
            }
        }

        return Math.max(dp[m-1][n-1][0], Math.max(dp[m-1][n-1][1], dp[m-1][n-1][2]));
    }
}