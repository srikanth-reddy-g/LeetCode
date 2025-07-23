class Solution {
    public boolean checkDivisibility(int n) {
        long product = 1;
        long sum = 0;
        int num = n;
        while (num > 0) {
            int digit = num % 10;
            sum += digit;
            product *= digit;
            num /= 10;
        }
        return n % (sum + product) == 0;
    }
}