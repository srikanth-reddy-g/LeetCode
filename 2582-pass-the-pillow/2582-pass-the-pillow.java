class Solution {
    public int passThePillow(int n, int time) {
        int j=1;
        int flag=0;
        for(int i=1;i<=time;i++){
            if(flag==0){
                j++;
                if(j==n) flag=1;
            }
            else{
                j--;
                if(j==1) flag=0;
            }
        }
        return j;
    }
}