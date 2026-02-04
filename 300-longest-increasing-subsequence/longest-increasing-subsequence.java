class Solution {
    public int lengthOfLIS(int[] nums) {
        // int[][] dp = new int[nums.length +1][nums.length+1];
        if (nums.length == 0) {
            return 0;
        }
        int max = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] > nums[prev]) {
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}