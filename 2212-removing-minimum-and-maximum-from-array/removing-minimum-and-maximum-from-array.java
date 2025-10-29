class Solution {
    public int minimumDeletions(int[] nums) {
        int min = 0;
        int max = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
            if (nums[i] < nums[min]) {
                min= i;
            }
        }

        int d1 = 0;
        int d2 = 0;
        if (min < max) {
            d1 = Math.min(max + 1, nums.length - min);
            d2 = (min + 1) + (nums.length - max);
        }
        else {
            d1 = Math.min(min + 1, nums.length - max);
            d2 = (max + 1) + (nums.length - min);
        }
        
        return Math.min(d1, d2);
    }
}