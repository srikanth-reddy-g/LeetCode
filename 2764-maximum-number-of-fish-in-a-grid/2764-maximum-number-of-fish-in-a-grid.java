class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int vis[][] = new int[m][n];
        int maxFish = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0 && grid[i][j] > 0) {
                    maxFish = Math.max(maxFish, dfs(i, j, grid, vis, m, n));
                }
            }
        }
        return maxFish;
    }

    private int dfs(int row, int col, int grid[][], int vis[][], int m, int n) {
        vis[row][col] = 1;
        int fish = grid[row][col];
        int delRow[] = { -1, 0, 1, 0 };
        int delCol[] = { 0, 1, 0, -1 };
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && vis[nRow][nCol] == 0 && grid[nRow][nCol] > 0) {
                fish += dfs(nRow, nCol, grid, vis, m, n);
            }
        }
        return fish;
    }
}