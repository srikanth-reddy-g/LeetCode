class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> answer=new ArrayList<>();
        int num1=Integer.MIN_VALUE,num2=Integer.MIN_VALUE;
        int cnt1=0,cnt2=0;
        // Modified Moore`s voting algorithm
        // since required answer is n/3 the final answer will only contain 2 or else elements

        for(int i=0;i<nums.length;i++){
            // num2!=nums[i] and num1!=nums[i] this conditions are important
            // The condition is to make elements of num1 and num2 to be unique
            if(cnt1==0 && num2!=nums[i])
            {
                cnt1++;
                num1=nums[i];
            }
            else if(cnt2==0 && num1!=nums[i])
            {
                cnt2++;
                num2=nums[i];
            }
            else if(num1==nums[i])
            {
                cnt1++;
            }
            else if(num2==nums[i])
            {
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }

        }
        cnt1=0;
        cnt2=0;
        // making final checks to check whether the answer is correct or not
        for(int i=0;i<nums.length;i++)
        {
            if(num1==nums[i]) cnt1++;
            if(num2==nums[i]) cnt2++;
        }
        if(cnt1>nums.length/3) answer.add(num1);
        if(cnt2>nums.length/3) answer.add(num2);
        return answer;
    }
}