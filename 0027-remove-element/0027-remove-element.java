class Solution {
    public int removeElement(int[] nums, int val) {
       int i=-1;
       int j=0;
       while(j<nums.length){
        if(nums[j]!= val){
            int temp=nums[j];
            nums[j]=nums[i+1];
            nums[i+1]=temp;
            i++;
        }
        j++;
       } 
       return i+1;
    }
}