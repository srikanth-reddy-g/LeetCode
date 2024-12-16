class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int num : nums) {
            high += num;
            low = Math.max(low, num);
        }
        while (low <= high) {
            int mid = (low + (high - low) / 2);
            if (isMinimum(nums, mid, k) == true) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isMinimum(int nums[], int maxSum, int k) {
        int arraysFormed = 1;
        int currentSum = 0;
        for (int num : nums) {
            if (currentSum + num <= maxSum) {
                currentSum += num;
            } else {
                arraysFormed++;
                currentSum = num;
            }
        }
        return arraysFormed <= k ? true : false;
    }
}