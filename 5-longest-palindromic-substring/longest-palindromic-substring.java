class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLen = 1;

        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (helper2(s, i , j, dp) == 1) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, maxLen + start);
    }
    private int helper2(String s, int start, int end, int[][] dp) {
        if (start >= end) {
            return 1;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        if (s.charAt(start) == s.charAt(end)) {
            dp[start][end] = helper2(s, start + 1, end - 1, dp);
        }
        else dp[start][end] = 0;
        
        return dp[start][end];
    }
}