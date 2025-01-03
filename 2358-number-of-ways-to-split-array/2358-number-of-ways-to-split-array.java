class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        long currentSum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currentSum += nums[i];
            if (currentSum >= sum - currentSum)
                ans++;
        }
        return ans;
    }
}