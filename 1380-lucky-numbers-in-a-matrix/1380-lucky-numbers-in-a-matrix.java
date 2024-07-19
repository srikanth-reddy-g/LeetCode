class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int rowMaxi=Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            int mini=Integer.MAX_VALUE;
            for(int j=0;j<matrix[i].length;j++){
                mini=Math.min(mini,matrix[i][j]);
            }
            rowMaxi=Math.max(rowMaxi,mini);
        }
        int colMini=Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++){
            int maxi=Integer.MIN_VALUE;
            for(int j=0;j<matrix.length;j++){
                maxi=Math.max(maxi,matrix[j][i]);
            }
            colMini=Math.min(maxi,colMini);
        }
        if(rowMaxi==colMini) return new ArrayList<>(Arrays.asList(colMini));
        return new ArrayList<>();
    }
}