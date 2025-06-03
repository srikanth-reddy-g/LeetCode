class Solution {
    private boolean isValid(char board[][], int row, int col) {
        char ch = board[row][col];
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == ch)
                return false;
            if (i != col && board[row][i] == ch)
                return false;
            int nRow = (3 * (row / 3)) + (i / 3);
            int nCol = (3 * (col / 3)) + (i % 3);
            if (nRow != row && nCol != col && board[nRow][nCol] == ch)
                return false;
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(board[i][j]) && !isValid(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
}