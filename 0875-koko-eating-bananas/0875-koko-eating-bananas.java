class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            maxi=Math.max(piles[i],maxi);
        }
        int low=0;
        int high=maxi;
        while(low<=high){
            int mid=(low+high)/2;
            if(calculateHours(piles,mid,h)) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    public boolean calculateHours(int piles[],int hrs,int h){
        double totalHrs=0;
        for(int i=0;i<piles.length;i++){
            totalHrs+=Math.ceil((double)piles[i]/(double)hrs);
        }
        return totalHrs<=(double)h;
    }
}