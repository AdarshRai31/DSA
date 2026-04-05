class Solution {
    public boolean judgeCircle(String moves) {
        int[] position = {0, 0};
        for(int i=0; i<moves.length(); i++) {
            if(moves.charAt(i) == 'U') {
                position[0] += 1;
            }
            if(moves.charAt(i) == 'D') {
                position[0] -= 1;
            }
            if(moves.charAt(i) == 'R') {
                position[1] += 1;
            }
            if(moves.charAt(i) == 'L') {
                position[1] -= 1;
            }
        }
        if(position[0] == 0 && position[1] == 0) {
            return true;
        }
        return false;
    }
}