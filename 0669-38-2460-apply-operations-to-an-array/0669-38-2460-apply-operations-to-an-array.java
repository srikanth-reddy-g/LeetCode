class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int i = 1;
        while (i < n) {
            if (nums[i] == nums[i - 1]) {
                nums[i - 1] *= 2;
                nums[i] = 0;
                i += 2;
            } else
                i++;
        }
        int pos = 0;
        int neg = 0;
        while (pos < n) {
            if (nums[pos] != 0) {
                int temp = nums[pos];
                nums[pos] = nums[neg];
                nums[neg] = temp;
                pos++;
                neg++;
            } else {
                pos++;
            }
        }
        return nums;
    }
}