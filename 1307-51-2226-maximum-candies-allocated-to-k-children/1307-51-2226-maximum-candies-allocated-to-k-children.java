class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low = 1;
        int high = 0;
        for (int candy : candies) {
            high = Math.max(high, candy);
        }
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (isMaximum(mid, candies, k)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    private boolean isMaximum(int num, int candies[], long k) {
        long numCount = 0;
        for (int candy : candies) {
            numCount += (candy / num);
        }
        return numCount >= k;
    }
}