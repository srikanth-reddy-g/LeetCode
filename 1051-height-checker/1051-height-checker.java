class Solution {
    public int heightChecker(int[] heights) {
        int expected[]=heights.clone();
        int ans=0;
        Arrays.sort(expected);
        for(int i=0;i<heights.length;i++){
            if(heights[i]!=expected[i]){
                ans++;
            }
        }
        return ans;
    }
}