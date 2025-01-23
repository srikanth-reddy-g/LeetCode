class Solution {
    public boolean isAnagram(String s, String t) {
        int characterHash[] = new int[27];
        for (int i = 0; i < s.length(); i++) {
            characterHash[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            characterHash[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 27; i++) {
            if (characterHash[i] > 0 || characterHash[i] < 0)
                return false;
        }
        return true;
    }
}