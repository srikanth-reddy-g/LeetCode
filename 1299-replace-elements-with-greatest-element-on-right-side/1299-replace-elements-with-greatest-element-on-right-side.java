class Solution {
    public int[] replaceElements(int[] arr) {
        int maxNum=-1;
        int prevValue=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            if(prevValue>=maxNum)
            maxNum=prevValue;
            prevValue=arr[i];
            arr[i]=maxNum;
        }
        arr[arr.length-1]=-1;
        return arr;
    }
}