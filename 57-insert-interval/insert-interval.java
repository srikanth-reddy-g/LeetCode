class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalsList = new ArrayList<>();
        int n = intervals.length;
        if (n == 0) {
            return new int[][] { newInterval };
        }
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (intervals[mid][0] <= newInterval[0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == low)
                intervalsList.add(newInterval);
            intervalsList.add(intervals[i]);
        }
        if (low == n)
            intervalsList.add(newInterval);
        List<int[]> merge = new ArrayList<>();
        merge.add(intervalsList.get(0));
        for (int i = 1; i < intervalsList.size(); i++) {
            int len = merge.size();
            if (merge.get(len - 1)[1] >= intervalsList.get(i)[0]) {
                merge.get(len - 1)[1] = Math.max(intervalsList.get(i)[1], merge.get(len - 1)[1]);
            } else {
                merge.add(intervalsList.get(i));
            }
        }
        int ans[][] = new int[merge.size()][2];
        for (int i = 0; i < merge.size(); i++) {
            ans[i] = merge.get(i);
        }
        return ans;
    }
}
