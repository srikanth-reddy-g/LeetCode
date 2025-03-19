class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ans[] = new int[nums1.length];
        Map<Integer, Integer> hashArr = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() < nums2[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                hashArr.put(nums2[i], -1);
            } else {
                hashArr.put(nums2[i], st.peek());
            }
            st.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = hashArr.get(nums1[i]);
        }
        return ans;
    }
}