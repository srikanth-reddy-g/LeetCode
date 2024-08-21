class Solution {
    int res=0;
    public int islandPerimeter(int[][] grid) {
        int M=grid.length;
        int N=grid[0].length;
        int vis[][]=new int[M][N];
        int delRow[]={-1,0,1,0};
        int delCol[]={0,1,0,-1};
        int res[]=new int[1];
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    dfs(i,j,grid,vis,delRow,delCol,M,N,res);
                }
            }
        }
        return res[0];
    }
    private void dfs(int row,int col,int grid[][],int vis[][],int delRow[],int delCol[],int M,int N,int res[]){
        vis[row][col]=1;
        for(int i=0;i<4;i++){
            int nRow=row+delRow[i];
            int nCol=col+delCol[i];
            res[0]+=1;
            if(nRow>=0 && nRow<M && nCol>=0 && nCol<N && grid[nRow][nCol]==1 && vis[nRow][nCol]==1) res[0]-=1;
            if(nRow>=0 && nRow<M && nCol>=0 && nCol<N && grid[nRow][nCol]==1 && vis[nRow][nCol]==0){
                res[0]-=1;
                dfs(nRow,nCol,grid,vis,delRow,delCol,M,N,res);
            }
        }
    }
}