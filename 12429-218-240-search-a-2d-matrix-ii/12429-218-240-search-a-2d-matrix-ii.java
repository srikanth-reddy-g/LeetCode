class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // Search starting from top-right
        int i = 0;
        int j = cols - 1;
        while (i < rows && j >= 0) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        // Search starting from bottom-left
        // int i = rows-1;
        // int j = 0;
        // while (i >= 0 && j < cols) {
        //     if (matrix[i][j] == target)
        //         return true;
        //     else if (matrix[i][j] > target) {
        //         i--;
        //     } else {
        //         j++;
        //     }
        // }
        return false;
    }
}