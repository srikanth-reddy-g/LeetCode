class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int ans[] = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            int count = 0;
            while (!st.isEmpty() && heights[st.peek()] < heights[i]) {
                count++;
                st.pop();
            }
            if (!st.isEmpty())
                count++;
            ans[i] = count;
            st.push(i);
        }
        return ans;
    }
}