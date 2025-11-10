class Solution {
    public static int findTargetSumWays(int[] nums, int target) {
        int tsum = 0;
        for (int i = 0; i < nums.length; i++) {
            tsum += nums[i];
        }

        if ((tsum + target) % 2 != 0 || tsum < Math.abs(target)) {
            return 0;
        }

        int sum = (tsum + target) / 2;

        if (sum < 0) {
            return 0;
        }

        int[][] dp = new int[nums.length + 1][sum + 1];

        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i-1][j - nums[i-1]] + dp[i-1][j];
                }
                else dp[i][j] = dp[i-1][j];
            }
        }

        return dp[nums.length][sum];
    }
}