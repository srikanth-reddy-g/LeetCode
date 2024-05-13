class Solution {
    public int matrixScore(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int score=0;
        for(int i=0;i<m;i++){
            if(grid[i][0]==0){
                for(int j=0;j<n;j++){
                    if(grid[i][j]==0) grid[i][j]=1;
                    else grid[i][j]=0;
                }
            }
        }
        for(int i=1;i<n;i++){
            int zeroCount=0;
            for(int j=0;j<m;j++){
                if(grid[j][i]==0) zeroCount++;
            }
            if(zeroCount>m-zeroCount){
                for(int j=0;j<m;j++){
                    if(grid[j][i]==0) grid[j][i]=1;
                    else grid[j][i]=0;
                }
            }
        }
        for(int i=0;i<m;i++){
            int num=0,pow2=1;
            for(int j=n-1;j>=0;j--){
                if(grid[i][j]==1) num+=pow2;
                pow2*=2;
            }
            score+=num;
        }
        return score;
    }
}