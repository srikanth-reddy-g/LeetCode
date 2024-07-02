class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int left=0;
        int right=0;
        List<Integer> ans=new ArrayList<>();
        while(left<nums1.length && right<nums2.length){
            if(nums1[left]==nums2[right]) {
                ans.add(nums1[left]);
                left++;
                right++;
            }
            else if(nums1[left]<nums2[right]) left++;
            else if(nums1[left]>nums2[right]) right++;
        }
        int result[]=ans.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}