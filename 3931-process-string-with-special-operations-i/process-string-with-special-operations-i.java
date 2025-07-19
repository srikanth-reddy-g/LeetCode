class Solution {
    public String processStr(String s) {
        StringBuilder res = new StringBuilder();
        int right = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (ch != '*' && ch != '#' && ch != '%') {
                res.append(ch);
            } else if (ch == '*') {
                if (res.length() > 0) {
                    res.deleteCharAt(res.length() - 1);
                }
            } else if (ch == '#') {
                res.append(res);
            } else if (ch == '%') {
                res.reverse();
            }
            right++;
        }
        return res.toString();
    }
}