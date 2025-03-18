class MinStack {

    Stack<Long> st;
    long mini = Integer.MAX_VALUE;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int value) {
        long val = (long) value;
        if (st.isEmpty()) {
            mini = val;
            st.push(val);
        } else {
            if (val >= mini)
                st.push(val);
            else {
                st.push(2 * val - mini);
                mini = val;
            }
        }

    }

    public void pop() {
        long num = st.pop();
        if (num < mini) {
            mini = 2 * mini - num;
        }

    }

    public int top() {
        long topEle = st.peek();
        if (topEle < mini)
            return (int) mini;
        return (int) topEle;
    }

    public int getMin() {
        return (int) mini;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */