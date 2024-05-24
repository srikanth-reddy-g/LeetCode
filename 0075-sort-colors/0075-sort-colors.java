class Solution {
    public void sortColors(int[] nums) {
        //Optimal solution 
        // Dutch National Flag Algorithm
        int low = 0;
        int high = nums.length - 1 ;
        int mid = 0;
        while(mid<=high)
        {
            if(nums[mid]==0)
            {
                int temp = nums[mid];
                nums[mid]=nums[low];
                nums[low]=temp;
                mid++;
                low++;
            }
            else if (nums[mid]==1)
                mid++;
            else
            {
                int temp = nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                high--;
            }
        }
        //Better Solution T.C = O(2N)
        // int cnt0=0;
        // int cnt1=0;
        // int cnt2=0;
        // for(int i = 0; i<nums.length;i++)
        // {
        //     if(nums[i]==0)
        //         cnt0++;
        //     else if(nums[i]==1)
        //         cnt1++;
        //     else
        //         cnt2++;
        // }
        // for(int i=0;i<cnt0;i++)nums[i]=0;
        // for(int i=cnt0;i<cnt0+cnt1;i++)nums[i]=1;
        // for(int i=cnt0+cnt1;i<cnt0+cnt1+cnt2;i++)nums[i]=2;
    }
}