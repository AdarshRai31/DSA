class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int L = 0;
        int dash = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'L') {
                L++;
            } else if (ch == 'R') {
                L--;
            } else {
                dash++;
            }
        }
        return Math.abs(L) + dash;
    }
}