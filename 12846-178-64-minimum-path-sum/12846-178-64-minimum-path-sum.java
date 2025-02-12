class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //Tabulation with space optimization
        int prev[]=new int[n];
        for(int row=0;row<m;row++){
            int current[]=new int [n];
            for(int col=0;col<n;col++){
                if(row==0 && col==0){
                    current[col]=grid[row][col];
                }
                else{
                    int up = Integer.MAX_VALUE/2;
                    if(row > 0)
                    up = grid[row][col] + prev[col];
                    int left = Integer.MAX_VALUE/2;
                    if(col > 0)
                    left = grid[row][col] + current[col-1];
                    current[col] = Math.min(up, left);
                }
            }
            prev=current;
        }
        return prev[n-1];


        // Tabulation

        // int dp[][] = new int[m][n];
        // dp[0][0]=grid[0][0];
        // for(int row=0;row<m;row++){
        //     for(int col=0;col<n;col++){
        //         if(row==0 && col==0){
        //             dp[row][col]=grid[row][col];
        //         }
        //         else{
        //             int up = Integer.MAX_VALUE/2;
        //             if(row > 0)
        //             up = grid[row][col] + dp[row - 1][col];
        //             int left = Integer.MAX_VALUE/2;
        //             if(col > 0)
        //             left = grid[row][col] + dp[row][col-1];
        //             dp[row][col] = Math.min(up, left);
        //         }
        //     }
        // }
        // return dp[m-1][n-1];
        // return findMinPathSum(m - 1, n - 1, grid, m, n, dp);
    }


    //Memoization
    
    // private int findMinPathSum(int row, int col, int grid[][], int m, int n, int dp[][]) {
    //     if (row == 0 && col == 0)
    //         return grid[row][col];
    //     if (row < 0 || col < 0)
    //         return Integer.MAX_VALUE/2;
    //     if (dp[row][col] != 0)
    //         return dp[row][col];
    //     int up = grid[row][col] + findMinPathSum(row - 1, col, grid, m, n, dp);
    //     int left = grid[row][col] + findMinPathSum(row, col - 1, grid, m, n, dp);
    //     return dp[row][col] = Math.min(up, left);
    // }
}