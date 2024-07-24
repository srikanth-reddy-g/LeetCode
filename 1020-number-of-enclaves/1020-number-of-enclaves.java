class Solution {
    public int numEnclaves(int[][] grid) {
        int M=grid.length;
        int N=grid[0].length;
        int vis[][]=new int[M][N];
        int ans=0;

        int delRow[]={-1,0,+1,0};
        int delCol[]={0,+1,0,-1};

        // Iterate over the border cells to find land cells and perform DFS
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                // Check if the cell is on the border and is a land cell that hasn't been visited
                if(i==0 || j==0 || i==M-1 || j==N-1){
                    if(vis[i][j]==0 && grid[i][j]==1){
                        dfs(i,j,vis,grid,M,N,delRow,delCol);
                    }
                }
            }
        }
        // Count the number of unvisited land cells (enclaves)
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(vis[i][j]==0 && grid[i][j]==1) ans++;
            }
        }
        return ans;
    }
    private void dfs(int row,int col,int vis[][],int grid[][],int M,int N,int delRow[],int delCol[]){
        vis[row][col]=1;
        for(int i=0;i<4;i++){
            int nRow=row+delRow[i];
            int nCol=col+delCol[i];
            // Check if the new cell is within bounds, is a land cell, and hasn't been visited
            if(nRow>=0 && nRow<M && nCol>=0 && nCol<N && vis[nRow][nCol]==0 && grid[nRow][nCol]==1){
                dfs(nRow,nCol,vis,grid,M,N,delRow,delCol);
            }
        }
    }
}