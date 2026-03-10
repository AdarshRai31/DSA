class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        long MOD = 1_000_000_007;
        long[][][] dp = new long[zero + 1][one + 1][2];

        // Base cases: only zeros or only ones (limited by 'limit')
        for (int i = 1; i <= Math.min(zero, limit); i++) dp[i][0][0] = 1;
        for (int j = 1; j <= Math.min(one, limit); j++) dp[0][j][1] = 1;

        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                // To end in 0, we take any valid array ending in 1 and add 0s
                // dp[i][j][0] = dp[i-1][j][0] + dp[i-1][j][1] - (invalid part)
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
                if (i > limit) {
                    // Subtract sequences that would have more than 'limit' zeros
                    dp[i][j][0] = (dp[i][j][0] - dp[i - limit - 1][j][1] + MOD) % MOD;
                }

                // To end in 1, we take any valid array ending in 0 and add 1s
                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
                if (j > limit) {
                    // Subtract sequences that would have more than 'limit' ones
                    dp[i][j][1] = (dp[i][j][1] - dp[i][j - limit - 1][0] + MOD) % MOD;
                }
            }
        }

        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}