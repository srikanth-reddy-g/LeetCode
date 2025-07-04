class Solution {

    int maxLength = 1;
    int startIndex = 0;

    private void getLongestPalindrome(String s, int stringLength, int left, int right) {
        while (left >= 0 && right < stringLength && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 > maxLength) {
                startIndex = left;
                maxLength = right - left + 1;
            }
            left--;
            right++;
        }
    }

    public String longestPalindrome(String s) {
        int stringLength = s.length();
        for (int i = 0; i < stringLength; i++) {
            getLongestPalindrome(s, stringLength, i - 1, i + 1);
            getLongestPalindrome(s, stringLength, i, i + 1);
        }
        return s.substring(startIndex, startIndex + maxLength);
    }
}