class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k)
            return false;
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            frequencyMap.put(s.charAt(i), frequencyMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        int oddCharacters = 0;
        for (Integer value : frequencyMap.values()) {
            if (value % 2 != 0) {
                oddCharacters++;
            }
            if (oddCharacters > k)
                return false;
        }
        return true;
    }
}