class Solution {
    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
            if (mpp.get(nums[i]) >= nums.length / 2) {
                ans = nums[i];
            }
        }
        return ans;
    }
}