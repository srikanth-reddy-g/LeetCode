class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m * k;
        int n = bloomDay.length; 
        if (val > n) return -1;
        int mini=Integer.MAX_VALUE;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            mini=Math.min(mini,bloomDay[i]);
            maxi=Math.max(maxi,bloomDay[i]);
        }
        int low=mini;
        int high=maxi;
        while(low<=high){
            int mid=(low+high)/2;
            if(bloom(bloomDay,mid,m,k)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public boolean bloom(int []bloomDay,int day,int m,int k){
        int count=0;
        int noOfBouquets=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=day){
                count+=1;
            }
            else{
                noOfBouquets+=(count/k);
                count=0;
            }
        }
        noOfBouquets+=(count/k);
        return (noOfBouquets>=m);
    }
}