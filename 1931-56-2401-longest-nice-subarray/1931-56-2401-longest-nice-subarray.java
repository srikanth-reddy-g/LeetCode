class Solution {
    public int longestNiceSubarray(int[] nums) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        int trackBits = 0;
        while (right < nums.length) {
            while ((trackBits & nums[right]) != 0) {
                trackBits = trackBits ^ nums[left];
                left++;
            }
            trackBits = trackBits | nums[right];
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}