class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length-1;
        int columnSize=matrix[0].length-1;
        int answer=0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(matrix[mid][columnSize]>=target)
            {
                answer=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }

        }
        System.out.println(answer);
        int l=0;
        int h=columnSize;
        while(l<=h)
        {
            int mid = (l+h)/2;
            System.out.println(mid);
            if(matrix[answer][mid]==target)
            return true;
            else if(matrix[answer][mid]>target)
            h=mid-1;
            else
            l=mid+1;
        }
        return false;
        // int n=matrix[0].length;
        // for(int i=0;i<matrix.length;i++)
        // {
        //     if(matrix[i][n-1]>=target)
        //     {
        //         for(int j=0;j<n;j++)
        //         {
        //             if(matrix[i][j]==target)
        //             return true;
        //         }
        //         break;
        //     }
        // }
        // return false;
    }
}