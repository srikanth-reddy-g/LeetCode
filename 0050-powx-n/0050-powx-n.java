class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1.0 / findPower(x, -(long) (n));
        }
        return findPower(x, (long) n);
    }

    private double findPower(double x, long n) {
        if (n == 0)
            return 1.0;
        if (n == 1)
            return x;
        if ((n % 2) == 0) {
            return findPower(x * x, n / 2);
        }
        return x * findPower(x, n - 1);
    }
}