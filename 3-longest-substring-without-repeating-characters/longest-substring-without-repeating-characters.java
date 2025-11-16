class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        HashMap<Character, Integer> seen = new HashMap<>();
        int max = 0;
        int i = 0;
        int j = 0;

        while (j < s.length()) {
            if (seen.containsKey(s.charAt(j))) {
                i = Math.max(i, seen.get(s.charAt(j)) + 1);
            }
                
            seen.put(s.charAt(j), j);
            
            j++;
            max = Math.max(max, j - i);
        }

        return max;
    }
}