class Solution {
    public int firstUniqChar(String s) {
        int charFreq[] = new int[27];
        for (int i = 0; i < s.length(); i++) {
            charFreq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (charFreq[s.charAt(i) - 'a'] == 1)
                return s.indexOf(s.charAt(i));
        }
        return -1;
    }
}