class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int M = (int)(1e9 + 7);
        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0]; j <= queries[i][1]; j += queries[i][2]) {
                long p = 1L * nums[j] * queries[i][3];
                nums[j] = (int) (p % M);
            }
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}