class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        if (n <= 2)
            return s;
        StringBuilder fancyString = new StringBuilder();
        fancyString.append(s.charAt(0));
        for (int i = 1; i <= n - 2; i++) {
            if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i + 1))
                continue;
            fancyString.append(s.charAt(i));
        }
        fancyString.append(s.charAt(n - 1));
        return fancyString.toString();
    }
}