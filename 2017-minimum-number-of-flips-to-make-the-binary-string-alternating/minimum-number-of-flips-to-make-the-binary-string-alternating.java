class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String s2 = s + s;
        char[] target1 = new char[2 * n];
        char[] target2 = new char[2 * n];
        
        for (int i = 0; i < 2 * n; i++) {
            target1[i] = (i % 2 == 0) ? '0' : '1';
            target2[i] = (i % 2 == 0) ? '1' : '0';
        }
        
        int diff1 = 0, diff2 = 0;
        int minFlips = Integer.MAX_VALUE;
        
        for (int i = 0; i < 2 * n; i++) {
            if (s2.charAt(i) != target1[i]) diff1++;
            if (s2.charAt(i) != target2[i]) diff2++;
            
            if (i >= n) {
                if (s2.charAt(i - n) != target1[i - n]) diff1--;
                if (s2.charAt(i - n) != target2[i - n]) diff2--;
            }
            
            if (i >= n - 1) {
                minFlips = Math.min(minFlips, Math.min(diff1, diff2));
            }
        }
        
        return minFlips;
    }
}