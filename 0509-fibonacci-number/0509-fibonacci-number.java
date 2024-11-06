class Solution {
    public int fib(int n) {
        int prev = 1;
        int lastPrev = 0;
        int res = 0;
        if (n == 0)
            return lastPrev;
        if (n == 1)
            return prev;
        for (int i = 1; i < n; i++) {
            res = (prev + lastPrev);
            lastPrev = prev;
            prev = res;
        }
        return res;
    }
}