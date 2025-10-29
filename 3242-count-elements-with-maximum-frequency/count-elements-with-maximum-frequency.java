class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        int maxFreq = 0;

        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(nums[i]));
        }

        int sum = 0;
        for (int n : freq.values()) {
            if (n == maxFreq) {
                sum += n;
            }
        }

        return sum;
    }
}