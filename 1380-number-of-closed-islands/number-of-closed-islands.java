class Solution {
    int rows;
    int cols;
    int delRow[] = { -1, 0, 1, 0 };
    int delCol[] = { 0, 1, 0, -1 };

    private void dfs(int row, int col, int grid[][], boolean vis[][]) {
        vis[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (nRow >= 0 && nCol >= 0 && nRow < rows && nCol < cols && !vis[nRow][nCol] && grid[nRow][nCol] == 0) {
                dfs(nRow, nCol, grid, vis);
            }
        }
    }

    public int closedIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        boolean vis[][] = new boolean[rows][cols];
        for (int i = 0; i < cols; i++) {
            if (grid[0][i] == 0 && !vis[0][i]) {
                dfs(0, i, grid, vis);
            }
            if (grid[rows - 1][i] == 0 && !vis[rows - 1][i]) {
                dfs(rows - 1, i, grid, vis);
            }
        }
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 0 && !vis[i][0]) {
                dfs(i, 0, grid, vis);
            }
            if (grid[i][cols - 1] == 0 && !vis[i][cols - 1]) {
                dfs(i, cols - 1, grid, vis);
            }
        }
        int ans = 0;
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (!vis[i][j] && grid[i][j] == 0) {
                    dfs(i, j, grid, vis);
                    ans++;
                }
            }
        }
        return ans;
    }
}