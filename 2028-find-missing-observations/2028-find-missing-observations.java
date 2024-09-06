class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int mSum=0;
        int nRolls[]=new int[n];
        for(int i=0;i<rolls.length;i++){
            mSum+=rolls[i];
        }
        int nSum=(((rolls.length+n)*mean)-mSum);
        if (nSum > 6 * n || nSum < n) return new int[0];
        int avgValue=nSum/n;
        int remainingValue=nSum%n;
        for(int i=0;i<n;i++){
            nRolls[i]=avgValue;            
        }
        for(int i=0;i<remainingValue;i++){
            nRolls[i]++;
        }
        return nRolls;
    }
}