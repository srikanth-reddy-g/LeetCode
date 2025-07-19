class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int num : arr)
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        int ans = -1;
        for (Map.Entry<Integer, Integer> pair : mpp.entrySet()) {
            if (pair.getKey().equals(pair.getValue()))
                ans = Math.max(ans, pair.getKey());
        }
        return ans;
    }
}