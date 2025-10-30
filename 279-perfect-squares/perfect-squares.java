class Solution {
    public int numSquares(int n) {
        int[] minCount = new int[n+1];

        Arrays.fill(minCount, Integer.MAX_VALUE);
        minCount[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j*j <= i; j++) {
                minCount[i] = Math.min(minCount[i], 1 + minCount[i - j*j]);
            }
        }
        return minCount[n];
    }
}