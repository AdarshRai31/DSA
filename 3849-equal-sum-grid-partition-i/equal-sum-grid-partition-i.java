class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        long totalSum = 0;

        // 1. Calculate the total sum of the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                totalSum += grid[i][j];
            }
        }

        // If total sum is odd, it's impossible to split into two equal integers
        if (totalSum % 2 != 0) {
            return false;
        }

        long target = totalSum / 2;

        // 2. Check for Horizontal Partition (Row-wise split)
        // We stop at rows - 1 because a partition must result in two non-empty grids
        long currentRowsSum = 0;
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols; j++) {
                currentRowsSum += grid[i][j];
            }
            if (currentRowsSum == target) {
                return true;
            }
        }

        // 3. Check for Vertical Partition (Column-wise split)
        // We stop at cols - 1 because a partition must result in two non-empty grids
        long currentColSum = 0;
        for (int j = 0; j < cols - 1; j++) {
            for (int i = 0; i < rows; i++) {
                currentColSum += grid[i][j];
            }
            if (currentColSum == target) {
                return true;
            }
        }

        return false;
    }
}