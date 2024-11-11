class Solution {
    public boolean isPalindrome(String str) {
        String s = str.replaceAll(" ", "").replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return stringPalindrome(0, s);
    }

    public boolean stringPalindrome(int i, String s) {
        if (i >= s.length() / 2)
            return true;
        if (s.charAt(i) != s.charAt(s.length() - i - 1))
            return false;
        return stringPalindrome(i + 1, s);
    }
}