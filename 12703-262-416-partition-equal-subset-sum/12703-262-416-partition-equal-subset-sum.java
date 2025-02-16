class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int target = 0;
        for (int i = 0; i < n; i++) {
            target += nums[i];
        }
        if (target % 2 != 0)
            return false;
        target /= 2;
        
        //Tabulation
        boolean dp[][] = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= target)
            dp[0][nums[0]] = true;
        for (int index = 1; index < n; index++) {
            for (int targetValue = 1; targetValue <= target; targetValue++) {
                boolean notPick = dp[index - 1][targetValue];
                boolean pick = false;
                if (nums[index] <= targetValue)
                    pick = dp[index - 1][targetValue - nums[index]];
                dp[index][targetValue] = pick || notPick;
            }
        }
        return dp[n - 1][target];

        // return isPartition(n - 1, nums, sum / 2, new boolean[n][sum / 2 + 1]);
    }

    //Memoization
    private boolean isPartition(int index, int nums[], int target, boolean dp[][]) {
        if (target == 0)
            return true;
        if (index == 0)
            return (nums[0] == target);
        if (dp[index][target])
            return dp[index][target];
        boolean notPick = isPartition(index - 1, nums, target, dp);
        boolean pick = false;
        if (nums[index] <= target)
            pick = isPartition(index - 1, nums, target - nums[index], dp);
        return dp[index][target] = pick || notPick;
    }
}