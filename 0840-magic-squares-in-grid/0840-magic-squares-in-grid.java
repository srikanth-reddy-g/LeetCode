class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                ans += helper(grid, i, j);
            }
        }
        return ans;
    }

    private int helper(int grid[][], int i, int j) {
        int sum = 0;
        int diagonalSum = 0;
        int numCheck[] = new int[16];
        for (int row = i; row < i + 3; row++) {
            sum = 0;
            for (int col = j; col < j + 3; col++) {
                sum += grid[row][col];
                if (row - i == col - j)
                    diagonalSum += grid[row][col];
                numCheck[grid[row][col]]++;
            }
            if (sum != 15)
                return 0;
        }
        if (diagonalSum != 15)
            return 0;
        for (int row = j; row < j + 3; row++) {
            sum = 0;
            for (int col = i; col < i + 3; col++) {
                sum += grid[col][row];
            }
            if (sum != 15)
                return 0;
        }
        for (int num = 1; num < 10; num++) {
            if (numCheck[num] != 1)
                return 0;
        }
        return 1;
    }
}
