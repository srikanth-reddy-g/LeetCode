class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Stack<Integer> st = new Stack<>();
        int ans[] = prices.clone();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && prices[st.peek()] >= prices[i]) {
                ans[st.pop()] -= prices[i];
            }
            st.push(i);
        }
        return ans;
        // Brute Force
        // int n = prices.length;
        // int ans[] = new int[n];
        // for (int i = 0; i < n - 1; i++) {
        // for (int j = i + 1; j < n; j++) {
        // if (prices[j] <= prices[i]) {
        // ans[i] = prices[i] - prices[j];
        // break;
        // }
        // if (j == n - 1)
        // ans[i] = prices[i];
        // }
        // }
        // ans[n - 1] = prices[n - 1];
        // return ans;
    }
}