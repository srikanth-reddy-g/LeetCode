class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int maxNum=Arrays.stream(arr1).max().getAsInt();
        int countArray[]=new int[maxNum+1];
        for(int i=0;i<arr1.length;i++){
            countArray[arr1[i]]++;
        }
        int index=0;
        for(int i=0;i<arr2.length;i++){
            int numSize=countArray[arr2[i]];
            while(numSize-- > 0){
                arr1[index++]=arr2[i];
                countArray[arr2[i]]--;
            }
        }
        for(int i=0;i<countArray.length;i++){
            int numSize=0;
            if(countArray[i]!=0)
            numSize=countArray[i];
            while(numSize-- > 0){
                arr1[index++]=i;
            }
        }
        return arr1;
    }
}