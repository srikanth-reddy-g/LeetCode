class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        List<Integer> ans=new ArrayList<>();
        int vis[]=new int[V];
        int pathVis[]= new int[V];
        int safeNode[]= new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,vis,pathVis,graph,ans,safeNode);
            }
        }
        for(int i=0;i<V;i++){
            if(safeNode[i]==1) ans.add(i);
        }
        return ans;
    }
    private boolean dfs(int node,int vis[],int pathVis[],int graph[][],List<Integer> ans,int safeNode[]){
        vis[node]=1;
        pathVis[node]=1;
        for(int it=0;it<graph[node].length;it++){
            if(vis[graph[node][it]]==0){
                if(dfs(graph[node][it],vis,pathVis,graph,ans,safeNode)==true)
                return true;
            }
            else if(pathVis[graph[node][it]]==1){
                return true;
            }
        }
        pathVis[node]=0;
        safeNode[node]=1;
        return false;
    }
}