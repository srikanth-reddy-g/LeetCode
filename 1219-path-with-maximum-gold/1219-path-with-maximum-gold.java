class Solution {
    public int getMaximumGold(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int maxGold=0;
        int delRow[]={-1,0,1,0};
        int delCol[]={0,1,0,-1};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0){
                    maxGold=Math.max(maxGold,dfs(grid,m,n,i,j,delRow,delCol));
                }
            }
        }
        return maxGold;
    }
    public int dfs(int grid[][],int m,int n,int row,int col, int delRow[], int delCol[]){
        if(row<0 || col<0 || row==m || col==n || grid[row][col]==0){
            return 0;
        }
        int maxGold=0;

        int actualGold=grid[row][col];
        grid[row][col]=0;
        for(int i=0;i<4;i++){
            int nRow=row+delRow[i];
            int nCol=col+delCol[i];
            maxGold=Math.max(maxGold,dfs(grid,m,n,nRow,nCol,delRow,delCol));
        }
        grid[row][col]=actualGold;
        return maxGold+actualGold;
    }
}