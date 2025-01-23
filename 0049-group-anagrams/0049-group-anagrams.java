class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int frequencyHash[] = new int[27];
        for (String s : strs) {
            Arrays.fill(frequencyHash, 0);
            for (char c : s.toCharArray())
                frequencyHash[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 27; i++) {
                sb.append('#');
                sb.append(frequencyHash[i]);
            }
            String key = sb.toString();
            if (!map.containsKey(key))
                map.put(key, new ArrayList<String>());
            map.get(key).add(s);

        }
        return new ArrayList(map.values());
    }
}