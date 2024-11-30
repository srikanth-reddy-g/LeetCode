class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> val = new HashMap<>();
        int ans = 0;
        int solIndex[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            ans = target - nums[i];
            if (val.containsKey(ans)) {
                solIndex[0] = i;
                solIndex[1] = val.get(ans);
                break;
            }
            val.put(nums[i], i);
        }
        return solIndex;

    }
}