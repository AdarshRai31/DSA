class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }

        long[] prefix = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long[] min = new long[k];
        Arrays.fill(min, Long.MAX_VALUE);

        long max = Long.MIN_VALUE;

        for (int s = 0; s <= nums.length; s++) {
            int r = s % k;
            if (min[r] != Long.MAX_VALUE) {
                max = Math.max(max, prefix[s] - min[r]);
            }
            min[r] = Math.min(min[r], prefix[s]);
        }
        return max;
    }
}