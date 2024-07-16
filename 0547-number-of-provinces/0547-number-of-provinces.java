class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<isConnected.length;i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=1;j<isConnected[0].length;j++){
                if(i!=j && isConnected[i][j]==1){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        int vis[]=new int[isConnected.length];
        int ans=0;
        for(int i=0;i<vis.length;i++){
            if(vis[i]==0){
                dfs(i,vis,adjList);
                ans++;
            }
        }
        return ans;
    }
    public void dfs(int node,int vis[],List<List<Integer>> adjList){
        vis[node]=1;
        for(Integer it:adjList.get(node)){
            if(vis[it]==0){
                dfs(it,vis,adjList);
            }
        }
    }
}