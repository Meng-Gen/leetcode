class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[] minSums = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    minSums[j] = (j == 0) ? grid[0][j] : minSums[j - 1] + grid[0][j];
                } else {
                    minSums[j] = (j == 0) ? minSums[j] + grid[i][j] : Math.min(minSums[j - 1], minSums[j]) + grid[i][j];
                }
            }
        }        
        return minSums[n - 1];
    }
}