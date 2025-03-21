class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int vis[] = new int[rooms.size()];
        bfs(0, rooms, vis);
        for (int i = 0; i < rooms.size(); i++) {
            if (vis[i] == 0)
                return false;
        }
        return true;
    }

    private void bfs(int node, List<List<Integer>> rooms, int vis[]) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        vis[node] = 1;
        while (!q.isEmpty()) {
            Integer vertex = q.poll();
            for (Integer it : rooms.get(vertex)) {
                if (vis[it] == 0) {
                    vis[it] = 1;
                    q.offer(it);
                }
            }
        }
    }
}