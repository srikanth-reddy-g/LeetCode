class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans[] = new int[2];
        int maxOnes = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int ones = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1)
                    ones++;
            }
            if (maxOnes < ones) {
                ans[0] = i;
                ans[1] = ones;
                maxOnes = ones;
            }
        }
        return ans;
    }
}