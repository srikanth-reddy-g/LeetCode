class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0;
        int j = 0;
        List<int[]> ans = new ArrayList<>();
        while (i < m && j < n) {
            if (nums1[i][0] == nums2[j][0]) {
                ans.add(new int[] { nums1[i][0], nums1[i][1] + nums2[j][1] });
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                ans.add(new int[] { nums1[i][0], nums1[i][1] });
                i++;
            } else {
                ans.add(new int[] { nums2[j][0], nums2[j][1] });
                j++;
            }
        }
        while (i < m) {
            ans.add(new int[] { nums1[i][0], nums1[i][1] });
            i++;
        }
        while (j < n) {
            ans.add(new int[] { nums2[j][0], nums2[j][1] });
            j++;
        }
        int res[][] = new int[ans.size()][2];
        for (int k = 0; k < ans.size(); k++) {
            res[k] = ans.get(k);
        }
        return res;
    }
}