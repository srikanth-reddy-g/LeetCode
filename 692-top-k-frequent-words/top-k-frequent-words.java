class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> mpp = new HashMap<>();
        Queue<Pair<Integer, String>> pq = new PriorityQueue<>((a, b) -> {
            if (!(a.getKey() == b.getKey())) {
                return Integer.compare(a.getKey(), b.getKey());
            } else {
                return b.getValue().compareTo(a.getValue());
            }
        });
        for (int i = 0; i < words.length; i++) {
            mpp.put(words[i], mpp.getOrDefault(words[i], 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : mpp.entrySet()) {
            pq.offer(new Pair(entry.getValue(), entry.getKey()));
            if (pq.size() > k) {
                pq.remove();
            }
        }
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            ans.add(0, pq.poll().getValue());
        }
        return ans;
    }
}