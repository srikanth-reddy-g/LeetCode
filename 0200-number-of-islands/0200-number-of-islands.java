class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int vis[][]=new int[m][n];
        int ans=0;
        int delRow[]={-1,0,1,0};
        int delCol[]={0,1,0,-1};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    dfs(i,j,vis,delRow,delCol,m,n,grid);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(int row,int col,int vis[][],int delRow[],int delCol[],int m,int n,char[][] grid){
        vis[row][col]=1;
        for(int i=0;i<4;i++){
            int nRow=row+delRow[i];
            int nCol=col+delCol[i];
            if(nRow>=0 && nRow<m &&
                nCol>=0 && nCol<n &&
                vis[nRow][nCol]==0 &&
                grid[nRow][nCol]=='1'){
                dfs(nRow,nCol,vis,delRow,delCol,m,n,grid);
            }
        }
        return;
    }
}