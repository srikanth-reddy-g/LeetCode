class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans=0;
        int j=0;
        for(int i=happiness.length-1;i>happiness.length-1-k;i--){
            if(happiness[i]-j >= 0)
            ans=ans+happiness[i]-j;
            else
            ans+=0;
            j++;
        }
        //Brute force
        // for(int i=0;i<k;i++){
        //     for(int j=0;j<happiness.length-i;j++){
        //         if(happiness[j]>0 && j!=happiness.length-i-1){
        //             happiness[j]--;
        //         }
        //         else{
        //             ans+=happiness[j];
        //         }
        //     }
        // }
        return ans;
    }
}