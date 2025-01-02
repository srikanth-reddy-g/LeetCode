class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int countArray[] = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            char firstLetter = words[i].charAt(0);
            char lastLetter = words[i].charAt(words[i].length() - 1);
            if ((firstLetter == 'a' || firstLetter == 'e' || firstLetter == 'i' || firstLetter == 'o'
                    || firstLetter == 'u')
                    && (lastLetter == 'a' || lastLetter == 'e' || lastLetter == 'i'
                            || lastLetter == 'o' || lastLetter == 'u')) {
                count++;
            }
            countArray[i] = count;
        }
        System.out.println(Arrays.toString(countArray));
        int ans[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = countArray[queries[i][1]] - (queries[i][0] == 0 ? 0 : countArray[queries[i][0] - 1]);
        }
        return ans;
    }
}