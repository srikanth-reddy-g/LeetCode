class Solution {
    public boolean isValid(String s) {
        Stack<Character> parenthesesStack=new Stack<>();
        for (int i = 0; i < s.length() ; i++ )
        {
            char currentChar=s.charAt(i);
            if (currentChar=='(' || currentChar=='[' || currentChar=='{')
            {
                parenthesesStack.push(currentChar);
            }
            else {
                if(parenthesesStack.isEmpty()) return false;
                char peekChar=parenthesesStack.peek();
                if ((!parenthesesStack.isEmpty()) && 
                ((peekChar=='(' && currentChar == ')')|| 
                (peekChar=='[' && currentChar == ']') || 
                (peekChar=='{' && currentChar == '}')))
                parenthesesStack.pop();
                else return false;
            }
        }
        return parenthesesStack.isEmpty();
    }
}