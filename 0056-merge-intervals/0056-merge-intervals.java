class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<List<Integer>> ans= new ArrayList<>();
        for(int i=0;i<intervals.length;i++)
        {
            if(ans.size()==0 || intervals[i][0]>ans.get(ans.size()-1).get(1))
            {
                ans.add(Arrays.asList(intervals[i][0],intervals[i][1]));
            }
            else{
                ans.get(ans.size()-1).set(1,Math.max(ans.get(ans.size()-1).get(1),intervals[i][1]));
            }
        }
        int[][] result = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            List<Integer> sublist = ans.get(i);
            result[i][0] = sublist.get(0);
            result[i][1] = sublist.get(1);
        }
        
        return result;
    }
}