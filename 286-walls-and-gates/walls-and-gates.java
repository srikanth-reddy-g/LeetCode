class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        int vis[][] = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    q.offer(new int[] { i, j });
                    vis[i][j] = 1;
                }
            }
        }
        int delRow[] = new int[] { -1, 0, 1, 0 };
        int delCol[] = new int[] { 0, 1, 0, -1 };
        int distance = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int row = q.peek()[0];
                int col = q.peek()[1];
                q.poll();
                rooms[row][col] = distance;
                for (int j = 0; j < 4; j++) {
                    int nRow = row + delRow[j];
                    int nCol = col + delCol[j];
                    if (nRow >= 0 && nCol >= 0 && nRow < m && nCol < n && rooms[nRow][nCol] == Integer.MAX_VALUE
                            && vis[nRow][nCol] == 0) {
                        q.offer(new int[] { nRow, nCol });
                        vis[nRow][nCol] = 1;
                    }
                }
            }
            distance++;
        }

    }
}