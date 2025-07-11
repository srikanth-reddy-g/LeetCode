class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> mpp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mpp.put(s.charAt(i), mpp.getOrDefault(s.charAt(i), 0) + 1);
        }
        int onesCount = 0;
        for (Integer value : mpp.values()) {
            if (value % 2 == 1)
                onesCount++;
            if (onesCount > 1)
                return false;
        }
        return true;
    }
}