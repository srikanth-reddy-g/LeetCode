class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int low = 0;
        int high = n1;
        while (low <= high) {
            int mid1 = low + ((high - low) / 2);
            int mid2 = ((n + 1) / 2) - (mid1);
            int leftMax1 = Integer.MIN_VALUE;
            int leftMax2 = Integer.MIN_VALUE;
            int rightMin1 = Integer.MAX_VALUE;
            int rightMin2 = Integer.MAX_VALUE;
            if (mid1 > 0)
                leftMax1 = nums1[mid1 - 1];
            if (mid2 > 0)
                leftMax2 = nums2[mid2 - 1];
            if (mid1 < n1)
                rightMin1 = nums1[mid1];
            if (mid2 < n2)
                rightMin2 = nums2[mid2];
            if (leftMax1 <= rightMin2 && leftMax2 <= rightMin1) {
                if (n % 2 == 1)
                    return (double) Math.max(leftMax1, leftMax2);
                return (double) (Math.max(leftMax1, leftMax2) + Math.min(rightMin1, rightMin2)) / 2.0;
            } else if (leftMax1 > rightMin2) {
                high = mid1 - 1;
            } else if (leftMax2 > rightMin1) {
                low = mid1 + 1;
            }

        }
        return 0;
    }
}