class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> mpp = new HashMap<>();
        mpp.put('2', "abc");
        mpp.put('3', "def");
        mpp.put('4', "ghi");
        mpp.put('5', "jkl");
        mpp.put('6', "mno");
        mpp.put('7', "pqrs");
        mpp.put('8', "tuv");
        mpp.put('9', "wxyz");
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        findCombinations(0, digits, mpp, ans, sb);
        return ans;
    }

    private void findCombinations(int index, String digits, Map<Character, String> mpp, List<String> ans,
            StringBuilder sb) {
        if (index >= digits.length()) {
            if (sb.length() > 0) {
                ans.add(sb.toString());
            }
            return;
        }
        for (int i = 0; i < mpp.get(digits.charAt(index)).length(); i++) {
            sb.append(mpp.get(digits.charAt(index)).charAt(i));
            findCombinations(index + 1, digits, mpp, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}