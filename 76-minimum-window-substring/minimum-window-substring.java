class Solution {
    public String minWindow(String s, String t) {
        int characterCount[] = new int[256];
        int count = t.length();
        for (char c : t.toCharArray()) {
            characterCount[c]++;
        }
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int minIndex = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (characterCount[ch] > 0) {
                count--;
            }
            characterCount[ch]--;
            while (count == 0) {
                if (right - left + 1 < minLength) {
                    minIndex = left;
                    minLength = right - left + 1;
                }
                characterCount[s.charAt(left)]++;
                if (characterCount[s.charAt(left)] > 0) {
                    count++;
                }
                left++;
            }
            right++;
        }
        minLength = minLength == Integer.MAX_VALUE ? 0 : minLength;
        return s.substring(minIndex, minIndex + minLength);
    }
}