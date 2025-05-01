class Solution {
    public int[][] generateMatrix(int n) {
        int num = 1;
        int top = 0, left = 0, bottom = n - 1, right = n - 1;
        int ans[][] = new int[n][n];
        while (left <= right && top <= bottom) {
            // left->right
            for (int i = left; i <= right; i++) {
                ans[top][i] = num;
                num++;
            }
            top++;
            //top->bottom
            for (int i = top; i <= bottom; i++) {
                ans[i][right] = num;
                num++;
            }
            right--;
            //right->left
            for (int i = right; i >= left; i--) {
                ans[bottom][i] = num;
                num++;
            }
            bottom--;
            //bootom->top
            for (int i = bottom; i >= top; i--) {
                ans[i][left] = num;
                num++;
            }
            left++;
        }
        return ans;
    }
}