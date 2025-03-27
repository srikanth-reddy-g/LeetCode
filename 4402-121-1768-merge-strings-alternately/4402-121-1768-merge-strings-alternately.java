class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int m = word1.length();
        int n = word2.length();
        while (i < m && i < n) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            i++;
        }
        if (i < m)
            sb.append(word1.substring(i, m));
        if (i < n)
            sb.append(word2.substring(i, n));
        return sb.toString();
    }
}