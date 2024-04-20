class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0,right=0,zeros=0;
        int length=0,maxLength=0;
        while(right<nums.length)
        {
            if(nums[right]==0) zeros++;
            if(zeros>k){
                if(nums[left]==0) zeros--;
                left++;
            }
            if(zeros<=k){
                length=right-left+1;
                maxLength=Math.max(length,maxLength);
            }
            right++;
        }
        return maxLength;
    }
}