class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        if (s1.isEmpty()) {
            return s2;
        }
        if (s2.isEmpty()) {
            return s1;
        }

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= s2.length(); i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        StringBuilder str = new StringBuilder();
        int i = s1.length(), j = s2.length();
        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                str.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if (dp[i-1][j] > dp[i][j-1]) {
                str.append(s1.charAt(i-1));
                i--;
            }
            else {
                str.append(s2.charAt(j-1));
                j--;
            }
        }

        while (i > 0) {
            str.append(s1.charAt(i-1));
            i--;
        }
        while (j > 0) {
            str.append(s2.charAt(j-1));
            j--;
        }

        return str.reverse().toString();
    }
}