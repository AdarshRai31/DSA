class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int n = robot.size();

        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        List<Integer> fact = new ArrayList<>();
        for (int i = 0; i < factory.length; i++) {
            for (int j = 0; j < factory[i][1]; j++) {
                fact.add(factory[i][0]);
            }
        }
        int m = fact.size();
        long[][] dp = new long[n][m];

        long INF = (long)1e15;
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }

        long min = INF;
        for (int i = 0; i < m; i++) {
            long dist = Math.abs((long)fact.get(i) - robot.get(0));
            min = Math.min(min, dist);
            dp[0][i] = min;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                long dist = Math.abs((long)fact.get(j) - robot.get(i));
                dp[i][j] = Math.min(dist + dp[i-1][j-1], dp[i][j-1]);
            }
        }

        return dp[n-1][m-1];
    }
}