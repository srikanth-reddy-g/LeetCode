class Solution {
    public List<String> partitionString(String s) {
        Map<String, Integer> mpp = new HashMap<>();
        List<String> ans = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < s.length();) {
            String sb = s.substring(j, i + 1);
            i++;
            if (!mpp.containsKey(sb)) {
                mpp.put(sb, i);
                ans.add(sb);
                j = i;
            }
        }
        return ans;
    }
}