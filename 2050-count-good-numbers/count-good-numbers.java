class Solution {
    long mod = 1000000007;
    private long pow(long x, long y) {
        long ans = 1;
        while (y > 0) {
            if (y % 2 == 0) {
                x = (x * x) % mod;
                y = y / 2;
            } else {
                ans = (ans * x) % mod;
                y--;
            }
        }
        return ans;
    }
    public int countGoodNumbers(long n) {
        return (int) ((pow(5, (n + 1) / 2) * pow(4, n / 2)) % mod);
    }
}