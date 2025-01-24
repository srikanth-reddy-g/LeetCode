class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return getSubarrays(nums, goal) - getSubarrays(nums, goal - 1);
    }

    private int getSubarrays(int[] nums, int goal) {
        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (left < right && sum > goal) {
                sum -= nums[left];
                left++;
            }
            if (sum <= goal) {
                count += (right - left + 1);
            }
            right++;
        }
        return count;
    }
}