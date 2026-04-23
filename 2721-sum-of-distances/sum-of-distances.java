class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];

        Map<Integer, List<Integer>> map = new HashMap<>();

        // Step 1: store indices
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        // Step 2: process each group
        for (List<Integer> list : map.values()) {
            int size = list.size();

            long prefixSum = 0;
            for (int i = 0; i < size; i++) {
                prefixSum += list.get(i);
            }

            long leftSum = 0;

            for (int i = 0; i < size; i++) {
                int idx = list.get(i);
                prefixSum -= idx;

                long left = (long) i * idx - leftSum;
                long right = prefixSum - (long)(size - i - 1) * idx;

                res[idx] = left + right;

                leftSum += idx;
            }
        }

        return res;
    }
}