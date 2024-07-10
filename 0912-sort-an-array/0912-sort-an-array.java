class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    public void mergeSort(int nums[],int low, int high){
        if(low>=high) return;
        int mid = (low+high)/2;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }
    public void merge(int nums[],int low,int mid,int high){
        int left=low;
        int right=mid+1;
        int newArray[]=new int[high+1];
        int i=0;
        while(left<=mid && right<=high){
            if(nums[left]<nums[right]){
                newArray[i++]=nums[left++];
            }
            else newArray[i++]=nums[right++];
        }
        while(left<=mid){
            newArray[i++]=nums[left++];
        }
        while(right<=high){
            newArray[i++]=nums[right++];
        }
        for(int j=low;j<=high;j++){
            nums[j]=newArray[j-low];
        }
    } 
}