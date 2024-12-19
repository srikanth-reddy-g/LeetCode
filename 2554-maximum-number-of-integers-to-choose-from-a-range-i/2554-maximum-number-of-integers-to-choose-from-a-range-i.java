class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        long sum = 0;
        int ansCount = 0;
        Set<Integer> hs = new HashSet<>();
        for (int num : banned) {
            hs.add(num);
        }
        for (int i = 1; i <= n; i++) {
            if (!hs.contains(i)) {
                sum += i;
                if (sum > maxSum)
                    break;
                ansCount++;
            }
        }
        return ansCount;
    }
}