class Solution {
    public int minAddToMakeValid(String s) {
        int openParentheses = 0, rem = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                openParentheses++;
            else {
                if (openParentheses <= 0)
                    rem++;
                else
                    openParentheses--;
            }
        }
        return openParentheses + rem;
    }
}