class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer=new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        int i=0;
        while(true)
        {
            if((m*n)==answer.size()) break;
            for(int j=0+i;j<n-i;j++)
            {
                answer.add(matrix[i][j]);
            }
            if((m*n)==answer.size()) break;
            for(int k=1+i;k<m-1-i;k++)
            {
                answer.add(matrix[k][n-i-1]);
            }
            if((m*n)==answer.size()) break;
            for(int l=n-i-1;l>=0+i;l--){
                answer.add(matrix[m-i-1][l]);
            }
            if((m*n)==answer.size()) break;
            for(int s=m-i-2;s>0+i;s--){
                answer.add(matrix[s][i]);
            }
            i++;
        }
        return answer;
    }
}