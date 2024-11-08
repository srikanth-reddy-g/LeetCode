class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int ans[] = new int[n];
        int maxNum = (int) (Math.pow(2, maximumBit)) - 1;
        int ithIndexXor = 0;
        for (int i = 0; i < n; i++) {
            ithIndexXor = ithIndexXor ^ nums[i];
            ans[n - 1 - i] = ithIndexXor ^ maxNum;
        }
        return ans;
    }
}