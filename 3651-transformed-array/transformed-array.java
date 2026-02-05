class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result[i] = nums[i];
            } else {
                int target = ((nums[i] + i) % n + n) % n;
                result[i] = nums[target];
            }
        }
        return result;
    }
}