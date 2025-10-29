class Solution {
    public int pivotIndex(int[] nums) {
        int tsum = 0;
        for (int i = 0; i < nums.length; i++) {
            tsum += nums[i];
        }

        int prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            if (prefix == tsum - prefix - nums[i]) {
                return i;
            }
            prefix += nums[i];
        }
        return -1;
    }
}