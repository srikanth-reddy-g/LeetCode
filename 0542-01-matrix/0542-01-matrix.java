// Define a Pair class to store the row, column, and steps taken
class Pair{
    int first;
    int second;
    int steps;
    public Pair(int first,int second,int steps){
        this.first=first;
        this.second=second;
        this.steps=steps;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int M=mat.length;
        int N=mat[0].length;
        int vis[][]=new int[M][N];
        int ans[][]=new int[M][N];
        Queue<Pair> q=new LinkedList<>();
        // initially add all the 0's to the queue stating the distance is 0
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(mat[i][j]==0){
                    vis[i][j]=1;    // Mark 0's as visited
                    q.add(new Pair(i,j,0)); // Add to queue with steps as 0
                }
            }
        }
        // Arrays to help with the four possible directions (up, right, down, left)
        int delRow[]={-1,0,+1,0};
        int delCol[]={0,+1,0,-1};

        // Perform BFS
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            int steps=q.peek().steps;
            q.remove();
            ans[row][col]=steps;    // Update the answer matrix with steps
            for(int i=0;i<4;i++){
                int nRow=row+delRow[i];
                int nCol=col+delCol[i];

                // Check if the new row and column are within bounds, not visited, and cell value is 1
                if(nRow>=0 && nCol>=0 && nRow<M && nCol<N && vis[nRow][nCol]==0 && mat[nRow][nCol]==1){
                    vis[nRow][nCol]=1;
                    q.add(new Pair(nRow,nCol,steps+1));
                } 
            }
        }
        return ans;
    }
}