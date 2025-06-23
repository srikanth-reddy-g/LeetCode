class Solution {
    private void dfs(int row, int col, int grid[][], int visited[][], int m, int n, int currArea[]) {
        int delRow[] = new int[] { 1, 0, -1, 0 };
        int delCol[] = new int[] { 0, 1, 0, -1 };
        visited[row][col] = 1;
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (nRow >= 0 && nCol >= 0 && nRow < m && nCol < n && grid[nRow][nCol] == 1 && visited[nRow][nCol] == 0) {
                currArea[0]++;
                dfs(nRow, nCol, grid, visited, m, n, currArea);
            }
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int visited[][] = new int[m][n];
        int delRow[] = new int[] { 1, 0, -1, 0 };
        int delCol[] = new int[] { 0, 1, 0, -1 };
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    int currArea[] = new int[] { 1 };
                    dfs(i, j, grid, visited, m, n, currArea);
                    maxArea = Math.max(maxArea, currArea[0]);
                }
            }
        }
        return maxArea;
    }
}