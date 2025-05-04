class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int n = nums.length;
        int sum = 0;
        int maxi = 0;
        mpp.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (mpp.containsKey(sum - k)) {
                maxi = Math.max(maxi, i - mpp.get(sum - k));
            }
            if (!mpp.containsKey(sum))
                mpp.put(sum, i);
        }
        return maxi;
    }
}