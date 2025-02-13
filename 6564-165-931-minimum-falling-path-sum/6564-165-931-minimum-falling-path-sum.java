class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;

        // Tabulation with sapce optimization
        int prev[] = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = matrix[n - 1][i];
        }
        for (int row = n - 2; row >= 0; row--) {
            int curr[] = new int[n];
            for (int col = n - 1; col >= 0; col--) {
                int down = matrix[row][col] + prev[col];
                int diagonalLeft = matrix[row][col];
                if (col > 0)
                    diagonalLeft += prev[col - 1];
                else
                    diagonalLeft = 100000000;
                int diagonalRight = matrix[row][col];
                if (col < n - 1)
                    diagonalRight += prev[col + 1];
                else
                    diagonalRight = 100000000;
                curr[col] = Math.min(down, Math.min(diagonalLeft, diagonalRight));
            }
            prev = curr;
        }
        for (int i = 0; i < n; i++) {
            min = Math.min(min, prev[i]);
        }
        return min;

        // Tabulation
        // int dp[][] = new int[n][n];
        // for (int i = 0; i < n; i++) {
        // dp[n - 1][i] = matrix[n - 1][i];
        // }
        // for (int row = n - 2; row >= 0; row--) {
        // for (int col = n - 1; col >= 0; col--) {
        // int down = matrix[row][col] + dp[row + 1][col];
        // int diagonalLeft = matrix[row][col];
        // if (col > 0)
        // diagonalLeft += dp[row + 1][col - 1];
        // else
        // diagonalLeft = 100000000;
        // int diagonalRight = matrix[row][col];
        // if (col < n - 1)
        // diagonalRight += dp[row + 1][col + 1];
        // else
        // diagonalRight = 100000000;
        // dp[row][col] = Math.min(down, Math.min(diagonalLeft, diagonalRight));
        // }
        // }
        // for (int i = 0; i < n; i++) {
        // min = Math.min(min, dp[0][i]);
        // }
        // return min;
    }

    // Memoization
    // private int findMinFallingPathSum(int row, int col, int matrix[][], int n,
    // int dp[][]) {

    // if (row == n - 1 && col >= 0 && col < n)
    // return matrix[row][col];
    // if (row < n && col < 0 || col >= n)
    // return 1000000000;
    // if (dp[row][col] != 0)
    // return dp[row][col];
    // int down = matrix[row][col] + findMinFallingPathSum(row + 1, col, matrix, n,
    // dp);
    // int diagonalLeft = matrix[row][col] + findMinFallingPathSum(row + 1, col - 1,
    // matrix, n, dp);
    // int diagonalRight = matrix[row][col] + findMinFallingPathSum(row + 1, col +
    // 1, matrix, n, dp);
    // return dp[row][col] = Math.min(down, Math.min(diagonalLeft, diagonalRight));
    // }
}