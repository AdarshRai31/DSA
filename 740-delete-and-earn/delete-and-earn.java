class Solution {
    public int deleteAndEarn(int[] nums) {
       int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        
        if (nums.length < 2) {
            return max;
        }

        int[] arr = new int[max + 1];

        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] += nums[i];
        }

        // house robber problem
        int[] dp = new int[max+1];
        dp[0] = arr[0];
        dp[1] = arr[1];

        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);
        }
        return dp[max];
    }
}