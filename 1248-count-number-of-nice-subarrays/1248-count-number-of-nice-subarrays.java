class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int value=0;
        int ans=0;
        Map<Integer,Integer> countMap=new HashMap<>();
        countMap.put(0,1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0){
                value++;
            }
            if(value>=k) ans+=countMap.getOrDefault(value-k,0);
            countMap.put(value,countMap.getOrDefault(value,0)+1);
        }
        return ans;
    }
}