class Solution {
    // Tabulation with Space Optimization
    public int climbStairs(int n) {
        int lastPrev = 0;
        int prev = 1;
        for (int i = 2; i <= n + 1; i++) {
            int currentSum = lastPrev + prev;
            lastPrev = prev;
            prev = currentSum;
        }
        return prev;
    }

    // Tabulation Method
    // public int climbStairs(int n) {
    // int dp[] = new int[n+2];
    // dp[0] = 0;
    // dp[1] = 1;
    // for (int i = 2; i <= n+1; i++) {
    // dp[i] = dp[i - 1] + dp[i - 2];
    // }
    // return dp[n+1];
    // }
    // Memoization
    // public int climbStairs(int n) {
    // int dp[] = new int[n + 1];
    // Arrays.fill(dp, -1);
    // return countClimbStairs(n, dp);
    // }

    // private int countClimbStairs(int n, int dp[]) {
    // if (n == 0)
    // return 1;
    // if (n < 0)
    // return 0;
    // if (dp[n] != -1)
    // return dp[n];
    // int left = countClimbStairs(n - 1, dp);
    // int right = countClimbStairs(n - 2, dp);
    // return dp[n] = left + right;
    // }

    // Recursive Approach
    // public int climbStairs(int n) {
    // if (n == 0)
    // return 1;
    // if (n < 0)
    // return 0;
    // int left = climbStairs(n - 1);
    // int right = climbStairs(n - 2);
    // return left + right;
    // }
}