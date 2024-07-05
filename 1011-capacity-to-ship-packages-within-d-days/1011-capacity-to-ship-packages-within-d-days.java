class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxCapacity=0;
        int minCapacity=Integer.MIN_VALUE;
        for(int i=0;i<weights.length;i++){
            maxCapacity+=weights[i];
            minCapacity=Math.max(minCapacity,weights[i]);
        }
        int low=minCapacity;
        int high=maxCapacity;
        while(low<=high){
            int mid=low+((high-low)/2);
            if(checkCapacity(mid,weights,days)) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    public boolean checkCapacity(int capacity,int weights[],int days){
        int weightsSum=0;
        int dayCount=0;
        System.out.println(capacity);
        for(int i=0;i<weights.length;i++){
            weightsSum+=weights[i];
            if(weightsSum>capacity){
                dayCount++;
                weightsSum=0;
                weightsSum+=weights[i];
            }
        }
        if(weightsSum!=0) dayCount++;
        return dayCount<=days;
    }
}