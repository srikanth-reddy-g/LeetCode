class Solution {
    public int minElement(int[] nums) {
        int minNum = Integer.MAX_VALUE;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < nums.length; i++) {
            sb.append(Integer.toString(nums[i]));
            int num = 0;
            for (int j = 0; j < sb.length(); j++) {
                num += (int) (sb.charAt(j) - '0');
            }
            sb.delete(0, sb.length());
            minNum = Math.min(minNum, num);
        }
        return minNum;
    }
}