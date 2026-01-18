class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int ans = 0;
        int l = 0 , r = n - 1, w;

        while (l < r) {
            w = r - l;
            int h = Math.min(height[l], height[r]);
            int curr = w * h;

            ans = Math.max(curr, ans);

            if (height[l] < height[r]) {
                l++;
            }
            else r--;
        }
        return ans;
    }
}