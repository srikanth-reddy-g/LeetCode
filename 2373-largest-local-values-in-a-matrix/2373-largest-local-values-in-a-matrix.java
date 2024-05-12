class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n=grid.length;
        int res[][]=new int[n-2][n-2];
        for(int row=0;row<n-2;row++){
            for(int col=0;col<n-2;col++){
                int maxLocal=-1;
                for(int i=row;i<row+3;i++){
                    for(int j=col;j<col+3;j++){
                        if(grid[i][j]>maxLocal){
                            maxLocal=grid[i][j];
                        }
                    }
                }
                res[row][col]=maxLocal;
            }
        }
        return res;
    }
}