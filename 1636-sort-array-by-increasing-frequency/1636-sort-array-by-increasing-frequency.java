class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        Integer numsObj[]=new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            numsObj[i]=nums[i];
        }
        Arrays.sort(numsObj,(a,b) -> { 
            if(map.get(a).equals(map.get(b))){
                return Integer.compare(b,a);
            }
            return Integer.compare(map.get(a),map.get(b));
        });
        for(int i=0;i<nums.length;i++){
            nums[i]=numsObj[i];
        }
        
        return nums;
    }
}