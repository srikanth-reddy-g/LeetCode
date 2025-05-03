class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                //checking the closet number nearer to target
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return target - diff;
    }
}