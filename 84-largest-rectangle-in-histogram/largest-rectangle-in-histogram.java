class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int prevSmallEleIdx[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.empty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            prevSmallEleIdx[i] = st.empty() ? -1 : st.peek();
            st.push(i);
        }
        st = new Stack<>();
        int nextSmallEleIdx[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            nextSmallEleIdx[i] = st.empty() ? n : st.peek();
            st.push(i);
        }
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int totalArea = heights[i] * (nextSmallEleIdx[i] - prevSmallEleIdx[i] - 1);
            maxArea = Math.max(maxArea, totalArea);
        }
        return maxArea;
    }
}