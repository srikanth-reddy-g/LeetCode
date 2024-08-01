class Solution {
    public boolean isBipartite(int[][] graph) {
        int vis[]=new int[graph.length];
        int color[]=new int[graph.length];
        for(int i=0;i<color.length;i++) color[i]=-1;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<vis.length;i++){
            if(vis[i]==0){
                if(bfs(i,graph,vis,color,q) == false) return false;
            }
        }
        return true;
    }
    public boolean bfs(int j,int[][] graph,int vis[],int color[],Queue<Integer> q){
        q.add(j);
        vis[j]=1;
        color[j]=0;
        while(!q.isEmpty()){
            int i=q.poll();
            for(int num:graph[i]){
                if(vis[num]==0){
                    vis[num]=1;
                    q.add(num);
                    color[num]=1-color[i];
                }
                else if(color[num]!=1-color[i]){
                    return false;
                }
            }
        }
        return true;
    }
}