class Solution {
    public int maximumSwap(int num) {
        char nums[] = Integer.toString(num).toCharArray();
        int n = nums.length;
        int swapIndex = -1, maxIndex = -1, swapIndex1 = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (maxIndex == -1 || nums[maxIndex] < nums[i]) {
                maxIndex = i;
            } else if (nums[i] < nums[maxIndex]) {
                swapIndex = i;
                swapIndex1 = maxIndex;
            }
        }
        if (swapIndex != -1 && swapIndex1 != -1) {
            char temp = nums[swapIndex];
            nums[swapIndex] = nums[swapIndex1];
            nums[swapIndex1] = temp;
        }
        return Integer.parseInt(new String(nums));
    }
}