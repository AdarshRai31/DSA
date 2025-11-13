class Solution {
    public int minOperations(int n) {
        int count = 0;
        while (n > 0) {
            int minRange = (int) (Math.log(n) / Math.log(2));
            int lower = Math.abs((1<<minRange) - n);
            int upper = (1<<(minRange + 1)) - n;

            if (lower > upper) {
                n = upper;
            }
            else {
                n = lower;
            }
            count++;
        }
        return count;
    }
}