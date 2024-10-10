class Solution {
    public int majorityElement(int[] nums) {
        int num=0;
        int cnt=0;
        for(int i = 0;i<nums.length;i++)
        {
            if(cnt==0)
            {
                num=nums[i];
            }
            if(nums[i]==num)
                cnt++;
            else
                cnt--;

        }
        return num;
        
    }
}