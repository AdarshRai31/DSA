class Solution {
    public int minPairSum(int[] nums) {
        int y = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            y = Math.max(y, nums[i]);
        }

        int[] arr = new int[y + 1];

        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }

        int left = 0, right = y;
        int ans = 0;
        while (left <= right) {
            while (left <= right && arr[left] == 0) left++;
            while (left <= right && arr[right] == 0) right--;

            if (left > right) break;

            ans = Math.max(ans, left + right);
            arr[left]--;
            arr[right]--;
        }
        
        return ans;
    }
}