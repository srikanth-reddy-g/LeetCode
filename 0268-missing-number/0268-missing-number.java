class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int j = nums.length;
        sum = ((j * (j + 1) / 2));
        for (int i = 0; i < j; i++) {
            sum = sum - nums[i];
        }
        return sum;

    }
}