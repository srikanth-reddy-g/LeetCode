class Solution {
    public void solve(char[][] board) {
        int M=board.length;
        int N=board[0].length;
        int vis[][]=new int[M][N];
        // Directions arrays to explore the four adjacent cells (up, right, down, left)
        int delRow[]={-1,0,+1,0};
        int delCol[]={0,+1,0,-1};
        // Perform DFS for 'O's on the boundary
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                // Check if the cell is on the boundary and contains 'O'
                if(i==0 || j==0 || i==M-1 || j==N-1){
                    if(vis[i][j]==0 && board[i][j]=='O'){
                        dfs(i,j,vis,board,M,N,delRow,delCol);
                    } 
                }
            }
        }
        // Replace unvisited 'O's with 'X'
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(vis[i][j]==0 && board[i][j]=='O')
                board[i][j]='X';
            }
        }
    }

    // DFS function to mark all connected 'O's starting from a given cell
    private void dfs(int row,int col,int vis[][],char board[][],int M,int N,int delRow[],int delCol[]){
        vis[row][col]=1;
        for(int i=0;i<4;i++){
            int nRow=row+delRow[i];
            int nCol=col+delCol[i];
            // Check if the adjacent cell is within bounds, unvisited, and contains 'O'
            if(nRow>=0 && nRow<M && nCol>=0 && nCol<N && vis[nRow][nCol]==0 && board[nRow][nCol]=='O'){
                dfs(nRow,nCol,vis,board,M,N,delRow,delCol);
            }
        }
    }
}