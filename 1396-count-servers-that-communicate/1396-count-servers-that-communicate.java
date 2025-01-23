class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int rowHash[] = new int[m];
        int colHash[] = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowHash[i]++;
                    colHash[j]++;
                }
            }
        }
        int servers = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rowHash[i] > 1 || colHash[j] > 1)) {
                    servers++;
                }
            }
        }
        return servers;
    }
}