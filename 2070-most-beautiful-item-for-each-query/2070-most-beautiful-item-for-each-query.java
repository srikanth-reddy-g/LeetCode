class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int ans[] = new int[queries.length];
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
        int max = items[0][1];
        for (int i = 0; i < items.length; i++) {
            max = Math.max(max, items[i][1]);
            items[i][1] = max;
        }
        for (int i = 0; i < queries.length; i++) {
            ans[i] = getMaximumBeauty(0, items.length - 1, items, queries[i]);
        }
        return ans;
    }

    private int getMaximumBeauty(int low, int high, int items[][], int num) {
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (items[mid][0] <= num)
                low = mid + 1;
            else
                high = mid - 1;
        }
        if (high < 0 || high >= items.length)
            return 0;
        return items[high][1];
    }
}