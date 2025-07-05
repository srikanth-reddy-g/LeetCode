class Solution {
    public List<Integer> partitionLabels(String s) {
        int lastOccurance[] = new int[27];
        for (int i = 0; i < s.length(); i++) {
            lastOccurance[s.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int partitionStart = 0;
        int partitionEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            if (partitionEnd < lastOccurance[s.charAt(i) - 'a']) {
                partitionEnd = lastOccurance[s.charAt(i) - 'a'];
            }
            if (i == partitionEnd) {
                result.add(partitionEnd - partitionStart + 1);
                partitionStart = i + 1;
            }
        }
        return result;
    }

}