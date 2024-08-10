class Solution {
    public int regionsBySlashes(String[] grid) {
        int gridLength = grid.length;
        int islandGrid[][] = new int[3 * gridLength][3 * gridLength];
        int delRow[] = { 0, 1, 0, -1 };
        int delCol[] = { 1, 0, -1, 0 };
        int regions = 0;
        for (int i = 0; i < gridLength; i++) {
            int initialRow = 3 * i;
            for (int j = 0; j < gridLength; j++) {
                int initialCol = 3 * j;
                if (grid[i].charAt(j) == '\\') {
                    islandGrid[initialRow][initialCol] = 1;
                    islandGrid[initialRow + 1][initialCol + 1] = 1;
                    islandGrid[initialRow + 2][initialCol + 2] = 1;
                } else if (grid[i].charAt(j) == '/') {
                    islandGrid[initialRow][initialCol + 2] = 1;
                    islandGrid[initialRow + 1][initialCol + 1] = 1;
                    islandGrid[initialRow + 2][initialCol] = 1;
                }
            }
        }
        for (int i = 0; i < islandGrid.length; i++) {
            for (int j = 0; j < islandGrid.length; j++) {
                if (islandGrid[i][j] == 0) {
                    dfs(i, j, islandGrid, delRow, delCol, islandGrid.length);
                    regions++;
                }
            }
        }
        return regions;
    }

    private void dfs(int row, int col, int islandGrid[][], int delRow[], int delCol[], int n) {
        islandGrid[row][col] = 2;
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (nRow >= 0 && nCol >= 0 && nRow < n && nCol < n && islandGrid[nRow][nCol] == 0) {
                dfs(nRow, nCol, islandGrid, delRow, delCol, n);
            }
        }
    }
}