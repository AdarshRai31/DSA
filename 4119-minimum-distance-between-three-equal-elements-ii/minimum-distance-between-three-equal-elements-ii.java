class Solution {
    public int minimumDistance(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        int minDist = Integer.MAX_VALUE;
        for (List<Integer> arr : map.values()) {
            if (arr.size() >= 3) {
                for (int i = 0; i <= arr.size() - 3; i++) {
                    int a = arr.get(i);
                    int c = arr.get(i+2);

                    int dist = 2 * Math.abs(c-a);
                    minDist = Math.min(dist, minDist);
                }
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}