class Solution {
    public int maximumCount(int[] nums) {
        // int pos = 0;
        // int neg = 0;
        // for (int i = 0; i < nums.length; i++) {
        // if (nums[i] < 0) {
        // neg++;
        // } else if (nums[i] > 0) {
        // pos++;
        // }
        // }
        // return Math.max(neg, pos);
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        return Math.max(n - upperBound(nums, n, low, high), lowerBound(nums, n, low, high));
    }

    private int upperBound(int nums[], int n, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= 0) {
                low = mid + 1;
            } else if (nums[mid] > 0) {
                high = mid - 1;
            }
        }
        return low;
    }

    private int lowerBound(int nums[], int n, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < 0) {
                low = mid + 1;
            } else if (nums[mid] >= 0) {
                high = mid - 1;
            }
        }
        return low;
    }
}