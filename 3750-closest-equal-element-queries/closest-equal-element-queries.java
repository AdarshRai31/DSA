class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> res = new ArrayList<>();
        int[] pre = new int[nums.length];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        for (List<Integer> arr : map.values()) {
            int m = arr.size();
            if (arr.size() <= 1) {
                for (int idx : arr) pre[idx] = -1;
                continue;
            }

            for (int i = 0; i < m; i++) {
                int curr = arr.get(i);

                int left = arr.get((i - 1 + m) % m);
                int right = arr.get((i + 1) % m);

                int distLeft = Math.abs(curr - left);
                distLeft = Math.min(distLeft, nums.length - distLeft);

                int distRight = Math.abs(curr - right);
                distRight = Math.min(distRight, nums.length - distRight);

                pre[curr] = Math.min(distLeft, distRight);
            }
        }

        for (int idx : queries) {
            res.add(pre[idx]);
        }
        return res;
    }
}