class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];

        // Tabulation
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                dp[i][j] = ((i - 1) >= 0 ? dp[i - 1][j] : 0) + ((j - 1) >= 0 ? dp[i][j - 1] : 0);
            }
        }
        return dp[m - 1][n - 1];
        // return findUniquePaths(m - 1, n - 1, m, n, dp);
    }

    // Memoization
    private int findUniquePaths(int row, int col, int m, int n, int dp[][]) {
        if (row < 0 || col < 0) {
            return 0;
        }
        if (row == 0 && col == 0) {
            return 1;
        }
        if (dp[row][col] != 0)
            return dp[row][col];
        int up = findUniquePaths(row - 1, col, m, n, dp);
        int left = findUniquePaths(row, col - 1, m, n, dp);
        return dp[row][col] = up + left;
    }
}