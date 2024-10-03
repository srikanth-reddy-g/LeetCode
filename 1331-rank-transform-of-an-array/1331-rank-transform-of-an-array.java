class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int arrLength=arr.length;
        if(arrLength==0) return arr;
        Integer indices[]=new Integer[arr.length];
        for(int i=0;i<arrLength;i++){
            indices[i]=i;
        }
        Arrays.sort(indices,(a,b)->Integer.compare(arr[a],arr[b]));
        int i=0;
        int rank=1;
        while(i<arrLength-1){
            int prev=arr[indices[i]];
            arr[indices[i]]=rank;
            if(prev!=arr[indices[i+1]]) rank++;
            i++;
        }
        arr[indices[i]]=rank;
        return arr;
    }
}