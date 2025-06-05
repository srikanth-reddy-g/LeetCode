class Pair {
    int val;
    int index;
    public Pair(int val, int index) {
        this.val = val;
        this.index = index;
    }
}

class StockSpanner {
    Stack<Pair> st;
    int idx = 0;

    public StockSpanner() {
        st = new Stack<Pair>();
        idx = 0;
    }

    public int next(int price) {
        while (!st.empty() && st.peek().val <= price) {
            st.pop();
        }
        int ans = idx - (st.isEmpty() ? -1 : st.peek().index);
        st.push(new Pair(price, idx++));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */