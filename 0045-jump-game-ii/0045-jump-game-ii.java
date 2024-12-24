class Solution {
    public int jump(int[] nums) {
        int maxReach = 0;
        int jump = 0;
        int jumpCount = 0;
        if (nums.length == 1)
            return 0;
        for (int i = 0; i < nums.length; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == jump) {
                jump = maxReach;
                jumpCount++;
                if (jump >= nums.length - 1)
                    break;
            }
        }
        return jumpCount;
    }
}