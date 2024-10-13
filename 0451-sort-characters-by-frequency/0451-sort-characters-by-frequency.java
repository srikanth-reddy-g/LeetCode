class Solution {
    public String frequencySort(String s) {
        int freqArray[] = new int[256];
        for (int i = 0; i < s.length(); i++) {
            freqArray[s.charAt(i)]++;
        }
        Integer indices[] = new Integer[256];
        for (int i = 0; i < 256; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> freqArray[b] - freqArray[a]);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 256; i++) {
            while (freqArray[indices[i]] != 0) {
                ans.append((char) ((int)indices[i]));
                freqArray[indices[i]]--;
            }
        }
        return ans.toString();
    }
}