class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length() + 1];

        dp[s.length()] = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;

            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    dp[i] = Math.min(dp[i], 1 + dp[j+1]);
                }
            }
        }
        return dp[0] - 1;
    }
    private static boolean isPalindrome(String s, int i, int j) {
        if (i == j) {
            return true;
        }
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}