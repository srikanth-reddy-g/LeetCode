class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int tCount[]=new int[1001];
        for(int i=0;i<target.length;i++){
            tCount[target[i]]++;
        }
        for(int i=0;i<arr.length;i++){
            tCount[arr[i]]--;
        }
        for(int i=0;i<tCount.length;i++){
            if(tCount[i]!=0) return false;
        }
        return true;
    }
}