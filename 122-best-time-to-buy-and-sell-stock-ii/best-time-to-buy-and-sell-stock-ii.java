class Solution {
    public int maxProfit(int[] prices) {
        int mini = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int currProfit = prices[i] - mini;
            mini = Math.min(mini, prices[i]);
            if (currProfit > 0) {
                mini = prices[i];
                profit = profit + currProfit;
            }
        }
        return profit;
    }
}