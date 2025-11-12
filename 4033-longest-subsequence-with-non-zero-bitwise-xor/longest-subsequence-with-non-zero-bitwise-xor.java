class Solution {
    public int longestSubsequence(int[] nums) {
        boolean zeros = false;
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                zeros = true;
            }
            xor ^= nums[i];
        }

        if (xor == 0) {
            if (zeros) return nums.length - 1;
            return 0;
        }
        return nums.length;
    }
}