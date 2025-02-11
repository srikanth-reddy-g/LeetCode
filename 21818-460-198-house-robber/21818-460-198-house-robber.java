class Solution {
    public int rob(int[] nums) {
        int len = nums.length;

        // Tabulation with space optimization
        int prev2 = 0;
        int prev = nums[0];
        int currentIndex = 0;
        for (int index = 1; index < len; index++) {
            int pick = nums[index];
            if (index - 2 >= 0) {
                pick += prev2;
            }
            int notPick = prev;
            currentIndex = Math.max(pick, notPick);
            prev2 = prev;
            prev = currentIndex;
        }
        return prev;

        // Tabulation
        // int dp[] = new int[len];
        // dp[0] = nums[0];
        // for (int index = 1; index < len; index++) {
        //     int pick = nums[index];
        //     if (index - 2 >= 0) {
        //         pick += dp[index - 2];
        //     }
        //     int notPick = dp[index - 1];
        //     dp[index] = Math.max(pick, notPick);
        // }
        // return dp[len - 1];
    }

    // Memoization
    // private int maxMoney(int index, int nums[], int dp[]) {
    // if (index == 0)
    // return nums[index];
    // if (index < 0)
    // return 0;
    // if (dp[index] != -1)
    // return dp[index];
    // int pick = nums[index] + maxMoney(index - 2, nums, dp);
    // int notPick = maxMoney(index - 1, nums, dp);
    // return dp[index] = Math.max(pick, notPick);
    // }
}