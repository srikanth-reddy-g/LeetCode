class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum=0;
        int maxCount=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int remainder=((sum%k)+k)%k;
            maxCount+=map.getOrDefault(remainder,0);
            map.put(remainder,map.getOrDefault(remainder,0)+1);
        }
        return maxCount;
    }
}