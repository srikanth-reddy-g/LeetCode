class Solution {

    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int low = 0;
        int high = nums.length - 1;
        int j = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                ans[low] = nums[i];
                low++;
            }
            if (nums[j] > pivot) {
                ans[high] = nums[j];
                high--;
            }
            j--;
        }
        while (low <= high) {
            ans[low] = pivot;
            low++;
        }
        return ans;
    }
}