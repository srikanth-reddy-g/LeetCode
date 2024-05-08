class Solution {
    public String[] findRelativeRanks(int[] score) {
        String ans[]=new String[score.length];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<score.length;i++){
            map.put(score[i],i);
        }
        Arrays.sort(score);
        int cnt=0;
        for(int i=score.length-1;i>=0;i--){
            if(i==score.length-1){
                ans[map.get(score[i])]="Gold Medal";
            }
            else if(i==score.length-2){
                ans[map.get(score[i])]="Silver Medal";
            }
            else if(i==score.length-3){
                ans[map.get(score[i])]="Bronze Medal";
            }
            else{
                ans[map.get(score[i])]=Integer.toString(cnt+1);
            }
            cnt++;
        }
        return ans;
    }
}