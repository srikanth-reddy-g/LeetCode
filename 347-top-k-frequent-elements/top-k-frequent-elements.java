class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (Map.Entry<Integer, Integer> pair : mpp.entrySet()) {
            pq.offer(new int[] { pair.getValue(), pair.getKey() });
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int ans[] = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[1];
        }
        return ans;
    }
}