class Solution {
    public int minimumLength(String s) {
        int freqArray[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freqArray[s.charAt(i) - 'a']++;
        }
        int minLength = 0;
        for (int i = 0; i < 26; i++) {
            if (freqArray[i] == 0)
                continue;
            if (freqArray[i] % 2 == 0) {
                minLength += 2;
            } else {
                minLength += 1;
            }
        }
        return minLength;
    }
}