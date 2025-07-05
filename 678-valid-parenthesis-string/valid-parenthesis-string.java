class Solution {
    public boolean checkValidString(String s) {
        int stringLength = s.length();
        Stack<Integer> openBracketIndex = new Stack<>();
        Stack<Integer> starIndex = new Stack<>();
        int leftPointer = 0;
        while (leftPointer < stringLength) {
            char ch = s.charAt(leftPointer);
            if (ch == '(') {
                openBracketIndex.push(leftPointer);
            } else if (ch == '*') {
                starIndex.push(leftPointer);
            } else {
                if (!openBracketIndex.isEmpty()) {
                    openBracketIndex.pop();
                } else if (!starIndex.isEmpty()) {
                    starIndex.pop();
                } else {
                    return false;
                }
            }
            leftPointer++;
        }
        while (!openBracketIndex.isEmpty() && !starIndex.isEmpty()) {
            if (openBracketIndex.pop() > starIndex.pop())
                return false;
        }
        return openBracketIndex.isEmpty();
    }
}