class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int C[] = new int[n];
        int freqArray[] = new int[n + 1];
        int count = 0;
        for (int i = 0; i < n; i++) {
            freqArray[A[i]]++;
            if (freqArray[A[i]] == 2)
                count++;

            freqArray[B[i]]++;
            if (freqArray[B[i]] == 2)
                count++;

            C[i] = count;

        }
        return C;
        // BruteForce
        // HashSet<Integer> set=new HashSet<>();
        // int n=A.length;
        // int C[]=new int[n];
        // for(int i=0;i<n;i++){
        // set.add(A[i]);
        // int count=0;
        // for(int j=0;j<=i;j++){
        // if(set.contains(B[j])) count++;
        // }
        // C[i]=count;
        // }
        // return C;
    }
}