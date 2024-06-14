class Solution {
    public int minIncrementForUnique(int[] nums) {
        int minIncrements=0;
        int maxValue=0;
        for(int i=0;i<nums.length;i++){
            maxValue=Math.max(maxValue,nums[i]);
        }
        int countArray[]=new int[nums.length+maxValue];
        for(int num: nums){
            countArray[num]+=1;
        }
        for(int i=0;i<countArray.length;i++){
            if(countArray[i]<=1) continue;
            int duplicateSize=countArray[i]-1;
            countArray[i+1]+=duplicateSize;
            minIncrements+=duplicateSize;
            countArray[i] = 1;
        }
        return minIncrements;
    }
}