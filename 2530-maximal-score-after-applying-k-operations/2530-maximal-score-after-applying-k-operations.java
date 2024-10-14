class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }
        long sum = 0;
        for (int i = 0; i < k; i++) {
            int maxElement = pq.poll();
            sum += maxElement;
            pq.add((int) Math.ceil((maxElement / 3.0)));
        }
        return sum;
    }
}