class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        return findUniquePaths(m - 1, n - 1, m, n, dp);
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