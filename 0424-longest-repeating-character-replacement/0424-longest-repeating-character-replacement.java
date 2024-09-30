class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, maxLength = 0, maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char chRight = s.charAt(right);
            map.put(chRight, map.getOrDefault(chRight, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(chRight));
            if ((right - left + 1) - maxFreq > k) {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}