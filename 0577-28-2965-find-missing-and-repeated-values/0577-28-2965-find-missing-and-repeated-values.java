class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int hashArray[] = new int[n * n + 1];
        int ans[] = { 0, 0 };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                hashArray[grid[i][j]]++;
            }
        }
        for (int i = 1; i < n * n + 1; i++) {
            if (hashArray[i] == 0) {
                ans[1] = i;
            } else if (hashArray[i] == 2) {
                ans[0] = i;
            }
        }
        return ans;
    }
}