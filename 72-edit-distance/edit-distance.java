class Solution {
    public static int minDistance(String word1, String word2) {
        int[] curr = new int[word2.length() + 1];
        int[] prev = new int[word2.length() + 1];

        for (int i = 0; i <= word2.length(); i++) {
            prev[i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            curr[0] = i;
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    curr[j] = prev[j-1];
                }
                else curr[j] = 1 + Math.min(prev[j], Math.min(curr[j-1], prev[j-1]));
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[word2.length()];
    }
}