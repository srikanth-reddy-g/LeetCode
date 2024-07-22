class Solution {
    public void gameOfLife(int[][] board) {
        int M=board.length;
        int N=board[0].length;
        int cloneBoard[][]=new int[M][N];
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                cloneBoard[i][j]=board[i][j];
            }
        }
        int delRow[]={-1,-1,0,+1,+1,+1,0,-1};
        int delCol[]={0,+1,+1,+1,0,-1,-1,-1};
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                int liveCell=0;
                for(int k=0;k<8;k++){
                    int nRow=i+delRow[k];
                    int nCol=j+delCol[k];
                    if(nRow>=0 && nRow<M && nCol>=0 && nCol<N && cloneBoard[nRow][nCol]==1){
                        liveCell++;
                    }
                }
                if(cloneBoard[i][j]==1 && liveCell<2) board[i][j]=0;
                else if(cloneBoard[i][j]==1 && (liveCell==2 || liveCell==3)) board[i][j]=1;
                else if(cloneBoard[i][j]==1 && liveCell>3) board[i][j]=0;
                else if(cloneBoard[i][j]==0 && liveCell==3) board[i][j]=1;
            }
        }
    }
}