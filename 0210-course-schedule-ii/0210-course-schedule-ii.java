class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int indegree[]=new int[numCourses];
        int M=prerequisites.length;
        Queue<Integer> q=new LinkedList<>();
        List<List<Integer>> list= new ArrayList<>();
        int ans[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList());
        }
        for(int i=0;i<M;i++){
            indegree[prerequisites[i][0]]++;
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.add(i);
        }
        int i=0;
        int cnt=0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(Integer it:list.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
            ans[i++]=node;
            cnt++;
        }
        return (cnt==numCourses) ? ans:new int[0];
    }
}