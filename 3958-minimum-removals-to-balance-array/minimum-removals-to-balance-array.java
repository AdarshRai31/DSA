class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);

        int max = 1;
        int j = 1;
        for(int i = 0; i < nums.length; i++) {
            while (j < nums.length && (long)nums[j] <= (long)nums[i]*k) {
                j++;
            }
            max = Math.max(max, j - i);
        }
        return nums.length - max;
    }
}