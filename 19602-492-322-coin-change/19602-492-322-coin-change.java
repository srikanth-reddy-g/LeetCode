class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        //Tabulation with space optimization
        int prev[] = new int[amount + 1];
        int curr[] = new int[amount + 1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0){
                prev[i]=i/coins[0];
            }
            else{
                prev[i]=1000000000;
            }
        }
        for (int index = 1; index < n; index++) {
            for (int amtValue = 0; amtValue <= amount; amtValue++) {
                int notPick = prev[amtValue];
                int pick = Integer.MAX_VALUE;
                if (amtValue >= coins[index]) {
                    pick = 1 + curr[amtValue - coins[index]];
                }
                curr[amtValue] = Math.min(notPick, pick);
            }
            prev=curr;
        }
        return prev[amount]== 1000000000 ? -1 : prev[amount];

        //Tabulation
        // int dp[][] = new int[n][amount + 1];
        // for(int i=0;i<=amount;i++){
        //     if(i%coins[0]==0){
        //         dp[0][i]=i/coins[0];
        //     }
        //     else{
        //         dp[0][i]=1000000000;
        //     }
        // }
        // for (int index = 1; index < n; index++) {
        //     for (int amtValue = 0; amtValue <= amount; amtValue++) {
        //         int notPick = dp[index - 1][amtValue];
        //         int pick = Integer.MAX_VALUE;
        //         if (amtValue >= coins[index]) {
        //             pick = 1 + dp[index][amtValue - coins[index]];
        //         }
        //         dp[index][amtValue] = Math.min(notPick, pick);
        //     }
        // }
        // return dp[n-1][amount]== 1000000000 ? -1 : dp[n-1][amount];




        // int ans = findMinCoins(n - 1, amount, coins, dp);
        // return ans == 1000000000 ? -1 : ans;
        
    }


    //Memoization
    private int findMinCoins(int index, int amount, int coins[], int dp[][]) {
        if (index == 0) {
            if (amount % coins[0] == 0)
                return amount / coins[0];
            return 1000000000;
        }
        if (dp[index][amount] != -1)
            return dp[index][amount];
        int notPick = findMinCoins(index - 1, amount, coins, dp);
        int pick = Integer.MAX_VALUE;
        if (amount >= coins[index]) {
            pick = 1 + findMinCoins(index, amount - coins[index], coins, dp);
        }
        return dp[index][amount] = Math.min(notPick, pick);
    }
}