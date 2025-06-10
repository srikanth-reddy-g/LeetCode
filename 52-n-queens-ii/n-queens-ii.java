class Solution {
    public int totalNQueens(int n) {
        int upDiagonal[] = new int[2 * n + 1];
        int downDiagonal[] = new int[2 * n + 1];
        int rowHash[] = new int[n];
        int ans[] = new int[] { 0 };
        countNQueens(0, n, upDiagonal, downDiagonal, rowHash, ans);
        return ans[0];

    }

    private void countNQueens(int col, int n, int upDiagonal[], int downDiagonal[], int rowHash[], int ans[]) {
        // if we reach the end of the column that means we are able to palce all the queens
        if (col == n) {
            ans[0]++;
            return;
        }
        for (int row = 0; row < n; row++) {
            //Check if the queen can be placed or not
            if (downDiagonal[row + col] == 0 && rowHash[row] == 0 && upDiagonal[col + n - row - 1] == 0) {
                //Mark the place stating queen is placed
                downDiagonal[row + col] = 1;
                rowHash[row] = 1;
                upDiagonal[col + n - row - 1] = 1;
                // Move to the next column 
                countNQueens(col + 1, n, upDiagonal, downDiagonal, rowHash, ans);
                //Backtrack and remove the queen from the position
                downDiagonal[row + col] = 0;
                rowHash[row] = 0;
                upDiagonal[col + n - row - 1] = 0;
            }
        }
    }
}