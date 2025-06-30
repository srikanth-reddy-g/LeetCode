class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            adjList.get(times[i][0]).add(new int[] { times[i][1], times[i][2] });
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0]));
        int dis[] = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        pq.offer(new int[] { 0, k });
        dis[k] = 0;
        while (!pq.isEmpty()) {
            int prevDistance = pq.peek()[0];
            int currNode = pq.peek()[1];
            pq.poll();
            for (int[] it : adjList.get(currNode)) {
                if (prevDistance + it[1] < dis[it[0]]) {
                    dis[it[0]] = prevDistance + it[1];
                    pq.offer(new int[] { prevDistance + it[1], it[0] });
                }
            }
        }
        int maxi = -1;
        for (int i = 1; i <= n; i++) {
            maxi = Math.max(maxi, dis[i]);
        }
        return maxi == Integer.MAX_VALUE ? -1 : maxi;
    }
}