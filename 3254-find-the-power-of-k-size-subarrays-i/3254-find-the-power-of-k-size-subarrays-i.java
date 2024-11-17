class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 1 || k == 1)
            return nums;
        int ans[] = new int[n - k + 1];
        int ansIndex = 0, badIndex = -1, left = 1, right = k;
        for (int i = 1; i < k; i++) {
            if (nums[i] != (1 + nums[i - 1])) {
                badIndex = i - 1;
            }
        }
        ans[ansIndex++] = (badIndex >= 0) ? -1 : nums[k - 1];
        while (right < n) {
            if (nums[right] != (1 + nums[right - 1]))
                badIndex = right - 1;
            ans[ansIndex++] = (badIndex >= left) ? -1 : nums[right];
            left++;
            right++;
        }

        return ans;
    }
}