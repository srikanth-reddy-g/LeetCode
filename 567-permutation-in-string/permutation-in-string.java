class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Hash = new HashMap<>();
        int windowLength = s1.length();
        if (s2.length() < windowLength)
            return false;
        for (int i = 0; i < windowLength; i++) {
            s1Hash.put(s1.charAt(i), s1Hash.getOrDefault(s1.charAt(i), 0) + 1);
        }
        Map<Character, Integer> s2Hash = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < s2.length()) {
            char ch1 = s2.charAt(right);
            s2Hash.put(ch1, s2Hash.getOrDefault(ch1, 0) + 1);
            if (right - left + 1 > windowLength) {
                char ch2 = s2.charAt(left);
                s2Hash.put(ch2, s2Hash.get(ch2) - 1);
                if (s2Hash.get(ch2) <= 0)
                    s2Hash.remove(ch2);
                left++;
            }
            if (s1Hash.equals(s2Hash))
                return true;
            right++;
        }
        return false;

    }
}