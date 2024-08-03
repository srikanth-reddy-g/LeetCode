class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxValue=0;
        int maxi=Integer.MIN_VALUE;
        int l=k-1,r=cardPoints.length-1;
        for(int i=0;i<k;i++){
            maxValue+=cardPoints[i];
            maxi=Math.max(maxi,maxValue);
        }
        while(l>=0){
            maxValue-=cardPoints[l];
            maxValue+=cardPoints[r];
            maxi=Math.max(maxi,maxValue);
            l--;
            r--;
        }
        return maxi;
    }
}