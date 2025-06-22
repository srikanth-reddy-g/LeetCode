class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            maxi = Math.max(maxi, Math.abs(nums[i] - nums[i - 1]));
        }
        maxi = Math.max(maxi, Math.abs(nums[0] - nums[n - 1]));
        return maxi;
    }
}