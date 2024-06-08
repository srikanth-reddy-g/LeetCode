class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int prefixSum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            if(map.containsKey(prefixSum%k)){
                if(i-map.get(prefixSum%k)>1)
                return true;
            }
            map.putIfAbsent(prefixSum%k,i);
        }
        return false;
    }
}