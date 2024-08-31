class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for(int j=0;j<k;j++){
            int minNum = Integer.MAX_VALUE;
            int minIndex=-1;
            for(int i=0;i<nums.length;i++){
                if(minNum>nums[i] && minNum!=nums[i]){
                    minNum=nums[i];
                    minIndex=i;
                }
            }
            nums[minIndex]*=multiplier;
        }
        return nums;
    }
}