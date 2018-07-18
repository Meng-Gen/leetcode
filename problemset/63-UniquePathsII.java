class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] ways = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    ways[j] = 0;
                } else {
                    if (i == 0 && j == 0) {
                        ways[j] = 1;
                    } else if (j > 0) {
                        ways[j] += ways[j - 1];
                    }
                }
            }
        }
        return ways[n - 1];
    }
}