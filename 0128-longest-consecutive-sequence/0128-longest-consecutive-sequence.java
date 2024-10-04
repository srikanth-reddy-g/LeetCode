class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLength = 0, count = 0;
        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            st.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!st.contains(nums[i] - 1)) {
                int initialNum = nums[i];
                count = 0;
                while (st.contains(initialNum)) {
                    count++;
                    initialNum++;
                }
                maxLength = Math.max(maxLength, count);
            }
        }
        return maxLength;
    }
}