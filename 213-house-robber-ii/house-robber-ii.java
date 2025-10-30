class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int a = helper4(nums, 0, nums.length - 2);
        int b = helper4(nums, 1, nums.length - 1);

        return Math.max(a, b);
    }
    private int helper4(int[] nums, int start, int index) {
        if (index < start) {
            return 0;
        }


        int prev1 = 0;
        int prev2 = nums[start];
        for (int i = start + 1; i <= index; i++) {
            int rob = prev1 + nums[i];
            int notRob = prev2;
            
            prev1 = prev2;
            prev2 = Math.max(rob, notRob);
        }
        return prev2;
    }
}