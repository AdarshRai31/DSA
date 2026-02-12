class Solution {
    public int longestBalanced(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];
            for (int j = i; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;

                if (isBalance(freq)) {
                    max = Math.max(max, j-i+1);
                }
            }
            if (max == s.length() - 1){
                return max;
            }
        }
        return max;
    }

    boolean isBalance(int[] freq) {
        int common = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                if (common == 0) {
                    common = freq[i];
                }
                if (common != freq[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}