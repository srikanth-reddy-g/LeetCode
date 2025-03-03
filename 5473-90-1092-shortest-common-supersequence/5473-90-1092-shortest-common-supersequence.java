class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[m][n]);
        StringBuilder ans = new StringBuilder();
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                ans.insert(0, str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i][j - 1] > dp[i - 1][j]) {
                ans.insert(0, str2.charAt(j - 1));
                j--;

            } else {
                ans.insert(0, str1.charAt(i - 1));
                i--;
            }
        }
        if (i == 0 && j != 0)
            ans.insert(0, str2.substring(0, j));
        else if (i != 0 && j == 0)
            ans.insert(0, str1.substring(0, i));

        return ans.toString();
    }
}