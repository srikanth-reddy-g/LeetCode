class Solution {
    public int subarraySum(int[] nums, int k) {
        //Take a HashMap to keep track of previous sum value till i th index
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int maxSubarray=0;
        map.put(sum,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int rem=sum-k;
            maxSubarray+=map.getOrDefault(rem,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return maxSubarray;
    }
}