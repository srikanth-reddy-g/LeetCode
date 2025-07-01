class Solution {
    public String reverseWords(String s) {
        int right = s.length() - 1;
        int left = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (left >= 0) {
            while (left >= 0 && s.charAt(left) == ' ') {
                left--;
            }
            right = left;
            if (right == -1)
                break;
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            sb.append(s.substring(left + 1, right + 1));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}