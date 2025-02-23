class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return findLCS(m - 1, n - 1, text1, text2, dp);
    }

    //Memoization
    private int findLCS(int i, int j, String text1, String text2, int dp[][]) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = (1 + findLCS(i - 1, j - 1, text1, text2, dp));
        }
        return dp[i][j] = Math.max(findLCS(i - 1, j, text1, text2, dp), findLCS(i, j - 1, text1, text2, dp));
    }
}