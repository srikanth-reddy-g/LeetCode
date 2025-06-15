class Solution {
    private int robHouse(int nums[], int start, int end) {
        int prev = 0;
        int lastPrev = 0;
        for (int i = start; i < end; i++) {
            int take = lastPrev + nums[i];
            int notTake = prev;
            int curr = Math.max(take, notTake);
            lastPrev = prev;
            prev = curr;
        }
        return prev;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        return Math.max(robHouse(nums, 1, n), robHouse(nums, 0, n - 1));
    }
}