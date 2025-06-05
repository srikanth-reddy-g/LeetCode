class Solution {
    private void solveNQueensPlacement(int col, int n, List<String> board, int upDiagonal[], int bottomDiagonal[],
            int rowHash[], List<List<String>> ans) {
        if (col == n) {
            ans.add(new ArrayList<>(board));
            return;
        }
        for (int row = 0; row < n; row++) {
            //Check if the postion is valid to place a queen
            if (upDiagonal[col - row + n - 1] == 0 && bottomDiagonal[row + col] == 0 && rowHash[row] == 0) {
                // Place the queen
                char charArray[] = board.get(row).toCharArray();
                charArray[col] = 'Q';
                board.set(row, new String(charArray));
                // Remember the postion where the queen is palce in the back
                upDiagonal[col - row + n - 1] = 1;
                bottomDiagonal[row + col] = 1;
                rowHash[row] = 1;
                // Check if the queen can be place in the next col
                solveNQueensPlacement(col + 1, n, board, upDiagonal, bottomDiagonal, rowHash, ans);
                // Remove the queen if it cannot be placed by backtrack
                charArray[col] = '.';
                board.set(row, new String(charArray));
                // Since the queen is removed making the positions to default
                upDiagonal[col - row + n - 1] = 0;
                bottomDiagonal[row + col] = 0;
                rowHash[row] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        int upDiagonal[] = new int[2 * n + 1];
        int bottomDiagonal[] = new int[2 * n + 1];
        int rowHash[] = new int[n];
        String dots = ".".repeat(n);
        for (int i = 0; i < n; i++) {
            board.add(dots);
        }
        solveNQueensPlacement(0, n, board, upDiagonal, bottomDiagonal, rowHash, ans);
        return ans;
    }
}