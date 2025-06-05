class Solution {
    private boolean dfs(int row, int col, char board[][], String word, int n, int m, StringBuilder sb, int vis[][],
            int delRow[], int delCol[]) {
        vis[row][col] = 1;
        sb.append(board[row][col]);
        if (sb.toString().equals(word))
            return true;
        if (sb.length() >= word.length())
            return false;
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (nRow >= 0 && nCol >= 0 && nRow < n && nCol < m && vis[nRow][nCol] == 0) {
                if (dfs(nRow, nCol, board, word, n, m, sb, vis, delRow, delCol) == true)
                    return true;
                vis[nRow][nCol] = 0;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int vis[][] = new int[n][m];
        int delRow[] = new int[] { -1, 0, 1, 0 };
        int delCol[] = new int[] { 0, 1, 0, -1 };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, board, word, n, m, sb, vis, delRow, delCol) == true)
                        return true;
                    vis[i][j] = 0;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return false;
    }
}