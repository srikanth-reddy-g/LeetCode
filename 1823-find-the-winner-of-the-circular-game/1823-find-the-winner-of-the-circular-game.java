class Solution {
    public int findTheWinner(int n, int k) {

        //Recursive approach T.c ---> O(n)  S.C ---> O(n)

        return winnerHelper(n,k) + 1 ;



        // T.C --> O(n*k)    S.C --->  O(n)
        // Queue<Integer> nums=new LinkedList<>();
        // for(int i=1;i<=n;i++){
        //     nums.add(i);
        // }
        // while(nums.size()>1){
        //     for(int i=1;i<k;i++){
        //         nums.add(nums.remove());
        //     }
        //     nums.remove();
        // }
        // return nums.peek();
    }

    private int winnerHelper(int n,int k){
        if(n==1){
            return 0;
        }
        return (winnerHelper(n-1,k) + k) % n;
    }
}