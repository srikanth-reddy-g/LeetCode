class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int characterCount[] = new int[26];
        int count = p.length();
        for (char c : p.toCharArray()) {
            characterCount[c - 'a']++;
        }
        int left = 0;
        int right = 0;
        List<Integer> result = new ArrayList<>();
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (characterCount[ch - 'a'] > 0) {
                count--;
            }
            characterCount[ch - 'a']--;
            while (count == 0) {
                if (count == 0 && right - left + 1 == p.length()) {
                    result.add(left);
                }
                characterCount[s.charAt(left) - 'a']++;
                if (characterCount[s.charAt(left) - 'a'] > 0) {
                    count++;
                }
                left++;
            }
            right++;
        }
        return result;
    }
}