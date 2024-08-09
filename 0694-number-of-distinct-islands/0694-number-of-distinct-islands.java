class Solution {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int vis[][] = new int[m][n];
        int delRow[] = { 0, 1, 0, -1 };
        int delCol[] = { 1, 0, -1, 0 };
        int ans = 0;
        Set<ArrayList<Integer>> st=new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    ArrayList<Integer> list=new ArrayList<>();
                    dfs(i, j, grid, vis, m, n, delRow, delCol, i, j,list);
                    st.add(list);
                }
            }
        }
        return st.size();
    }

    private void dfs(int row, int col, int grid[][], int vis[][], int m, int n, int delRow[], int delCol[],int iniRow,int iniCol,ArrayList<Integer> list) {
        vis[row][col] = 1;
        list.add(row-iniRow,col-iniCol);
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1) {
                dfs(nRow, nCol, grid, vis, m, n, delRow, delCol,iniRow,iniCol,list);
            }
        }
    }
}