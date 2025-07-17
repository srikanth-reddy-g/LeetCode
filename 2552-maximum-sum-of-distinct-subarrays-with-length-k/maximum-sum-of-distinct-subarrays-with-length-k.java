class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int left = 0;
        int right = 0;
        long sum = 0;
        long maxSum = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        while (right < nums.length) {
            if (right - left + 1 > k) {
                mpp.put(nums[left], mpp.getOrDefault(nums[left], 0) - 1);
                if (mpp.get(nums[left]) <= 0)
                    mpp.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            mpp.put(nums[right], mpp.getOrDefault(nums[right], 0) + 1);
            sum += nums[right];
            if (mpp.size() == k)
                maxSum = Math.max(maxSum, sum);
            right++;
        }
        return maxSum;
    }
}