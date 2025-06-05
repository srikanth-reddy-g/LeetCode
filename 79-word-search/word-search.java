class Solution {
    private boolean dfs(int row, int col, char[][] board, String word, int index,
            int n, int m, int[][] vis, int[] delRow, int[] delCol) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= n || col >= m || vis[row][col] == 1 || board[row][col] != word.charAt(index)) {
            return false;
        }
        vis[row][col] = 1;
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if (dfs(nRow, nCol, board, word, index + 1, n, m, vis, delRow, delCol)) {
                return true;
            }
        }
        vis[row][col] = 0;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        int[][] vis = new int[n][m];
        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, board, word, 0, n, m, vis, delRow, delCol)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
