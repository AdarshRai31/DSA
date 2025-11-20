class Solution {
    public static boolean isMatch(String s, String p) {
        boolean[] prev = new boolean[p.length() + 1];
        boolean[] curr = new boolean[p.length() + 1];
        prev[0] = true;

//        for s= "..." and p = "" always false
        for (int i = 1; i <= p.length(); i++) {
            prev[i] = p.charAt(i-1) == '*' && prev[i-1];
        }

        for (int i = 1; i <= s.length(); i++) {
            curr[0] = false;
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    curr[j] = prev[j-1];
                }
                else if (p.charAt(j - 1) == '*') {
                    curr[j] = curr[j-1] || prev[j];
                }
                else curr[j] = false;
            }
            boolean[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[p.length()];
    }
}