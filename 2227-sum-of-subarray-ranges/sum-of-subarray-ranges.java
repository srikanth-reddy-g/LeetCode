class Solution {
    private void computeIndices(int[] nums, int[] prev, int[] next, boolean isMin) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && (isMin ? nums[stack.peek()] >= nums[i] : nums[stack.peek()] <= nums[i])) {
                stack.pop();
            }
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && (isMin ? nums[stack.peek()] > nums[i] : nums[stack.peek()] < nums[i])) {
                stack.pop();
            }
            next[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
    }

    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] prevMin = new int[n], nextMin = new int[n];
        int[] prevMax = new int[n], nextMax = new int[n];
        computeIndices(nums, prevMin, nextMin, true);
        computeIndices(nums, prevMax, nextMax, false);
        long minSum = 0, maxSum = 0;
        for (int i = 0; i < n; i++) {
            minSum += (nums[i] * (long) ((i - prevMin[i]) * (nextMin[i] - i)));
            maxSum += (nums[i] * (long) ((i - prevMax[i]) * (nextMax[i] - i)));
        }
        return maxSum - minSum;
    }
}