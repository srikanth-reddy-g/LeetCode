class Solution {
    public int[] productExceptSelf(int[] nums) {
        int j=nums.length-1;
        Map<Integer,Integer> prefixMul =new HashMap<>();
        Map<Integer,Integer> sufixMul =new HashMap<>();
        for(int i=0;i<nums.length;i++){
            prefixMul.put(i,prefixMul.getOrDefault(i-1,1)*nums[i]);
            sufixMul.put(j,sufixMul.getOrDefault(j+1,1)*nums[j]);
            j--;
            
        }
        j=nums.length;
        for(int i=0;i<j;i++){
            if(i==0){
                nums[i]=sufixMul.get(i+1);
            }
            else if(i==j-1){
                nums[i]=prefixMul.get(i-1);
            }
            else{
                nums[i]=prefixMul.get(i-1)*sufixMul.get(i+1);
            }
        }
        return nums;

    }
}