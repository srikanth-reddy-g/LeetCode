class Solution {
    private void dfs(int node, List<Integer> adjList[], int vis[]) {
        vis[node] = 1;
        for (Integer it : adjList[node]) {
            if (vis[it] == 0) {
                dfs(it, adjList, vis);
            }
        }

    }

    public int countComponents(int n, int[][] edges) {
        List<Integer> adjList[] = new ArrayList[n];
        int vis[] = new int[n];
        int noOfConnectedComponents = 0;
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                noOfConnectedComponents++;
                dfs(i, adjList, vis);
            }
        }
        return noOfConnectedComponents;
    }
}