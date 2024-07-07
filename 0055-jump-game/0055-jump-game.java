class Solution {
    public boolean canJump(int[] nums) {
        int maxReach=Integer.MIN_VALUE;
        int jump=0;
        for(int i=0;i<nums.length;i++){
            jump=i+nums[i];
            if(jump>maxReach) maxReach=jump;
            if(maxReach>=nums.length-1) return true;
            if(maxReach==i && nums[i]==0) break;
        }
        return false;
    }
}