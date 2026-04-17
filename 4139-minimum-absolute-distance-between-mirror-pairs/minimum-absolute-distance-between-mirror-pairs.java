class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            
            if (map.containsKey(nums[i])) {
                int dist = i - map.get(nums[i]);
                min = Math.min(min, dist);
            }
            int x = reverse(nums[i]);
            map.put(x, i);
        }

        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

    int reverse(int n) {
        int sum = 0;
        while (n != 0) {
            int a = n % 10;
            sum = sum * 10 + a;
            n /= 10;
        }
        return sum;
    }
}