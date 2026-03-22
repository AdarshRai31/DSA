class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        if(mat.length != target.length) return false;
        for (int i= 0; i< 4; i++) {
            if(isEqual(mat, target)) {
                return true;
            }
            mat = rotate90(mat);
        }
        return false;
    }

    public boolean isEqual(int[][] mat, int[][] target) {
        for (int i = 0; i< mat.length; i++) {
            if(!Arrays.equals(mat[i], target[i])) {
                return false;
            }
        }
        return true;
    }

    public int[][] rotate90(int[][] mat) {
        int[][] res = new int[mat[0].length][mat.length];
        int n = mat.length;
        for (int i = 0; i< n; i++) {
            for (int j =0; j< mat[i].length; j++) {
                res[j][n - i - 1] = mat[i][j];
            }
        }
        return res;
    }
}