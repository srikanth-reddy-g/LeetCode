class Solution {
    public boolean divideArray(int[] nums) {
        if (nums.length % 2 != 0)
            return false;
        int hashArr[] = new int[501];
        for (int num : nums) {
            hashArr[num]++;
        }
        for (int i = 1; i < 501; i++) {
            if (hashArr[i] % 2 != 0)
                return false;
        }
        return true;
    }
}