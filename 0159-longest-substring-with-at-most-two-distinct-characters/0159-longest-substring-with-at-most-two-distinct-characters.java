class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int leftPointer = 0;
        int rightPointer = 0;
        Map<Character, Integer> charFrequency = new HashMap<>();
        int length = 0;
        int maxLength = 0;
        while (rightPointer < s.length()) {
            charFrequency.put(s.charAt(rightPointer), charFrequency.getOrDefault(s.charAt(rightPointer), 0) + 1);
            if (charFrequency.size() > 2) {
                charFrequency.put(s.charAt(leftPointer), charFrequency.get(s.charAt(leftPointer)) - 1);
                if (charFrequency.get(s.charAt(leftPointer)) == 0)
                    charFrequency.remove(s.charAt(leftPointer));
                leftPointer++;
            }
            if (charFrequency.size() <= 2) {
                length = rightPointer - leftPointer + 1;
                maxLength = Math.max(length, maxLength);
            }
            rightPointer++;
        }
        return maxLength;
    }
}