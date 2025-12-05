class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int prefix = nums[0];
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if ((2*prefix - sum) % 2 == 0) {
                ans++;
            }
            prefix += nums[i];
        }
        return ans;
    }
}