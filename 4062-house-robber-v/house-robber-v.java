class Solution {
    public long rob(int[] nums, int[] colors) {
        if (nums.length == 0) {
            return 0;
        }
        long prev = nums[0];
        if (nums.length == 1) {
            return prev;
        }
        long curr = (colors[1] != colors[0]) ? nums[1] + prev : Math.max(nums[1], nums[0]);

        for (int i = 2; i < nums.length; i++) {
            long next;
            if (colors[i] != colors[i-1]) {
                next = curr + nums[i];
            }
            else {
                next = Math.max(curr, nums[i] + prev);
            }
            prev = curr;
            curr = next;
        }
        return curr;
    }
}