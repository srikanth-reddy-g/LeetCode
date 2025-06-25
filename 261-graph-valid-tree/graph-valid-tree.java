class Solution {
    private boolean dfs(int node, List<List<Integer>> adjList, int vis[], int parent) {
        vis[node] = 1;
        for (Integer it : adjList.get(node)) {
            if (vis[it] == 0) {
                if (dfs(it, adjList, vis, node))
                    return true;
            } else if (it != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        int vis[] = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        if (dfs(0, adjList, vis, -1))
            return false;
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0)
                return false;
        }
        return true;
    }
}