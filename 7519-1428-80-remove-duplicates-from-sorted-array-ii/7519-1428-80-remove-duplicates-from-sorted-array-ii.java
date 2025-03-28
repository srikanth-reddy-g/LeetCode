class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 1;
        int prev = nums[0];
        int i = 1, j = 0;
        while (i <= n) {
            int cnt = 1;
            while (i < n && nums[i] == prev) {
                cnt++;
                i++;
            }
            if (cnt == 1) {
                nums[j++] = prev;
            } else if (cnt >= 2) {
                nums[j++] = prev;
                nums[j++] = prev;
            }
            if (i < n)
                prev = nums[i];
            i++;
        }
        return j;
    }
}