class Solution {
    public static int minFallingPathSum(int[][] matrix) {
        int[] prev = new int[matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            prev[i] = matrix[0][i];
        }

        for (int i = 1; i < matrix.length; i++) {
            int[] temp = new int[matrix[0].length];
            for (int j = 0; j < matrix[i].length; j++) {
                int down = prev[j];
                int ldiagonal = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    ldiagonal = prev[j-1];
                }
                int rDiagonal = Integer.MAX_VALUE;
                if (j + 1 <= matrix[i].length - 1) {
                    rDiagonal = prev[j+1];
                }
                temp[j] = matrix[i][j] + Math.min(down, Math.min(ldiagonal, rDiagonal));
            }
            prev = temp;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prev.length; i++) {
            min = Math.min(min, prev[i]);
        }
        return min;
    }
}