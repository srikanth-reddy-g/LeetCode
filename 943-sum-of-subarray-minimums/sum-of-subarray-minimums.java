class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1000000007;
        int prevSmallEleIdx[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            prevSmallEleIdx[i] = st.empty() ? -1 : st.peek();
            st.push(i);
        }
        int nextSmallEleIdx[] = new int[n];
        st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            nextSmallEleIdx[i] = st.empty() ? n : st.peek();
            st.push(i);
        }
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum = totalSum + (arr[i] * (long)((i - prevSmallEleIdx[i]) * (nextSmallEleIdx[i] - i)))%mod;
        }
        return (int) (totalSum % mod);
    }
}