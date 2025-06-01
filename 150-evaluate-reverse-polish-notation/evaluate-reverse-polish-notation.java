class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+-*/".contains(tokens[i])) {
                int secondNum = st.pop();
                int firstNum = st.pop();
                int result = 0;
                switch (tokens[i]) {
                    case "+":
                        result = firstNum + secondNum;
                        break;
                    case "-":
                        result = firstNum - secondNum;
                        break;
                    case "*":
                        result = firstNum * secondNum;
                        break;
                    case "/":
                        result = firstNum / secondNum;
                        break;
                }
                st.push(result);
            } else {
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.peek();
    }
}