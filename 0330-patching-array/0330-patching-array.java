class Solution {
    public int minPatches(int[] nums, int n) {
        int i=0;
        int noOfPatches=0;
        long maxReach=0;
        while(maxReach<n){
            if(i<nums.length && nums[i]<=(maxReach+1)){
                maxReach+=nums[i];
                i++;
            }
            else{
                maxReach+=(maxReach+1);
                noOfPatches++;
            }
        }
        return noOfPatches;
    }
}