class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        Set<String> ans = new HashSet<>();
        if (n < 10)
            return new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= n - 10; i++) {
            String dna = s.substring(i, i + 10);
            map.put(dna, map.getOrDefault(dna, 0) + 1);
            if (map.get(dna) > 1)
                ans.add(dna);
        }
        return new ArrayList<>(ans);

    }
}