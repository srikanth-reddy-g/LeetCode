class Solution {
    // private int minCost(int n, int cost[], int dp[]) {
    //     if (n <= 1)
    //         return 0;
    //     if (dp[n] != 0)
    //         return dp[n];
    //     int twoSteps = Integer.MAX_VALUE;
    //     if (n >= 2)
    //         twoSteps = minCost(n - 2, cost, dp) + cost[n - 2];
    //     int oneStep = Integer.MAX_VALUE;
    //     if (n >= 1)
    //         oneStep = minCost(n - 1, cost, dp) + cost[n - 1];
    //     return dp[n] = Math.min(oneStep, twoSteps);
    // }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int lastPrev = 0;
        int prev = 0;
        for (int i = 2; i <= n; i++) {
            int twoSteps = lastPrev + cost[i - 2];
            int oneStep = prev + cost[i - 1];
            int curr = Math.min(oneStep, twoSteps);
            lastPrev = prev;
            prev = curr;
        }
        return prev;
        // int dp[] = new int[n + 1];
        // for (int i = 2; i <= n; i++) {
        //     int twoSteps = dp[i - 2] + cost[i - 2];
        //     int oneStep = dp[i - 1] + cost[i - 1];
        //     dp[i] = Math.min(oneStep, twoSteps);
        // }
        // return dp[n];
        // return minCost(n, cost, dp);
    }
}