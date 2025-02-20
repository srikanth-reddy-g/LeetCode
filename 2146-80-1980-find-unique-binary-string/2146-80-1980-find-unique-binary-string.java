class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> hs = new HashSet<String>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            hs.add(nums[i]);
        }
        findCombinations(0, sb, n, hs);
        return sb.toString();
    }

    private boolean findCombinations(int index, StringBuilder sb, int n, Set<String> hs) {
        if (index >= n) {
            System.out.println(sb.toString());
            if (hs.contains(sb.toString()))
                return false;
            else
                return true;
        }
        sb.append("0");
        if (findCombinations(index + 1, sb, n, hs) == true)
            return true;
        sb.deleteCharAt(sb.length() - 1);
        sb.append("1");
        if (findCombinations(index + 1, sb, n, hs) == true)
            return true;
        sb.deleteCharAt(sb.length() - 1);
        return false;
    }
}