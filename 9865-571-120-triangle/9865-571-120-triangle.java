class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();

        // Tabulation with space optimization
        int prev[]=new int[n];
        for(int i=0;i<n;i++){
            prev[i]=triangle.get(m - 1).get(i);
        }
        for (int row = m - 2; row >= 0; row--) {
            int cur[]=new int [n];
            for (int col = row; col >= 0; col--) {
                int num = triangle.get(row).get(col);
                int down = num + prev[col];
                int diagonal = num + prev[col + 1];
                cur[col] = Math.min(down, diagonal);
            }
            prev=cur;
        }
        return prev[0];


        // Tabulation
        // int dp[][] = new int[n][n];
        // for (int i = 0; i < n; i++) {
        //     dp[m - 1][i] = triangle.get(m - 1).get(i);
        // }
        // for (int row = m - 2; row >= 0; row--) {
        //     for (int col = row; col >= 0; col--) {
        //         int num = triangle.get(row).get(col);
        //         int down = num + dp[row + 1][col];
        //         int diagonal = num + dp[row + 1][col + 1];
        //         dp[row][col] = Math.min(down, diagonal);
        //     }
        // }
        // return dp[0][0];
        // return findMinimumTotal(0, 0, triangle, m, dp);
    }

    // Memoization
    private int findMinimumTotal(int row, int col, List<List<Integer>> triangle, int m, int dp[][]) {
        if (row == m - 1)
            return triangle.get(row).get(col);
        if (dp[row][col] != 0)
            return dp[row][col];
        int down = triangle.get(row).get(col) + findMinimumTotal(row + 1, col, triangle, m, dp);
        int diagonal = triangle.get(row).get(col) + findMinimumTotal(row + 1, col + 1, triangle, m, dp);
        return dp[row][col] = Math.min(down, diagonal);
    }
}