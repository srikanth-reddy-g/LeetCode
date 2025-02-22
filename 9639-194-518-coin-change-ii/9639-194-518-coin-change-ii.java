class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;

        //Tabulation with space optimization
        int prev[] = new int[amount + 1];
        int curr[] = new int[amount + 1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0){
                prev[i]=1;
            }
        }
        for (int index = 1; index < n; index++) {
            for (int amtValue = 0; amtValue <= amount; amtValue++) {
                int notPick = prev[amtValue];
                int pick = 0;
                if (amtValue >= coins[index]) {
                    pick = curr[amtValue - coins[index]];
                }
                curr[amtValue] = notPick + pick;
            }
            prev=curr;
        }
        return prev[amount];


        // Tabulation
        // int dp[][] = new int[n][amount + 1];
        // for(int i=0;i<=amount;i++){
        //     if(i%coins[0]==0){
        //         dp[0][i]=1;
        //     }
        //     else{
        //         dp[0][i]=0;
        //     }
        // }
        // for (int index = 1; index < n; index++) {
        //     for (int amtValue = 0; amtValue <= amount; amtValue++) {
        //         int notPick = dp[index - 1][amtValue];
        //         int pick = 0;
        //         if (amtValue >= coins[index]) {
        //             pick = dp[index][amtValue - coins[index]];
        //         }
        //         dp[index][amtValue] =notPick+pick;
        //     }
        // }
        // return dp[n-1][amount];
        
        // return findMinCoins(n - 1, amount, coins, dp);
    }


    //Memoization
    private int findMinCoins(int index, int amount, int coins[], int dp[][]) {
        if (index == 0) {
            if (amount % coins[0] == 0)
                return 1;
            return 0;
        }
        if (dp[index][amount] != -1)
            return dp[index][amount];
        int notPick = findMinCoins(index - 1, amount, coins, dp);
        int pick = 0;
        if (amount >= coins[index]) {
            pick = findMinCoins(index, amount - coins[index], coins, dp);
        }
        return dp[index][amount] = notPick + pick;
    }
}