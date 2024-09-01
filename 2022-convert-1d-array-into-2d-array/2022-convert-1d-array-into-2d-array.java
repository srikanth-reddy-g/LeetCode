class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int result2DMatrix[][]=new int [m][n];
        if(original.length!=m*n) return new int[0][0];
        int k=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result2DMatrix[i][j]=original[k++];
            }
        }
        return result2DMatrix;
    }
}