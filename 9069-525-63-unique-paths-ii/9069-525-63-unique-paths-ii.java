class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];

        // Tabulation
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 && col == 0 && obstacleGrid[row][col] != 1)
                    dp[0][0] = 1;
                else {
                    int down = 0;
                    if (row - 1 >= 0 && obstacleGrid[row][col] != 1) {
                        down = dp[row - 1][col];
                    }
                    int right = 0;
                    if (col - 1 >= 0 && obstacleGrid[row][col] != 1) {
                        right = dp[row][col - 1];
                    }
                    dp[row][col] = down + right;

                }
            }
        }
        return dp[m - 1][n - 1];
        // return findUniquePathsWithObstacles(m - 1, n - 1, obstacleGrid, m, n, dp);
    }

    // Memoization
    private int findUniquePathsWithObstacles(int row, int col, int obstacleGrid[][], int m, int n, int dp[][]) {
        if (row == 0 && col == 0)
            return 1;
        if (row < 0 || col < 0)
            return 0;
        if (dp[row][col] != 0)
            return dp[row][col];
        int up = 0;
        if (obstacleGrid[row][col] != 1) {
            up = findUniquePathsWithObstacles(row - 1, col, obstacleGrid, m, n, dp);
        }
        int left = 0;
        if (obstacleGrid[row][col] != 1) {
            left = findUniquePathsWithObstacles(row, col - 1, obstacleGrid, m, n, dp);
        }
        return dp[row][col] = up + left;
    }
}