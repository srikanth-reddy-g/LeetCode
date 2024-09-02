class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long arraySum = 0;
        for (int i = 0; i < chalk.length; i++) {
            arraySum += chalk[i];
        }
        long updatedK = k % arraySum;
        if (updatedK == 0)
            return 0;
        for (int i = 0; i < chalk.length; i++) {
            if (updatedK < chalk[i])
                return i;
            updatedK -= chalk[i];
        }
        return 0;
    }
}
