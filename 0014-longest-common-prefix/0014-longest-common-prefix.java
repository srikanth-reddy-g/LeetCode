class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder string = new StringBuilder();
        int flag = 0;
        if (strs.length <= 1)
            return strs[0];
        for (int i = 0; i < strs[0].length(); i++) {
            int match = 0;
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                match = 0;
                int strLength = strs[j].length();
                if (i < strLength && strs[j].charAt(i) == ch)
                    match = 1;
                else {
                    flag = 1;
                    break;
                }
            }
            if (match == 1)
                string.append(ch);
            if (flag == 1)
                break;
        }
        return string.toString();
    }
}