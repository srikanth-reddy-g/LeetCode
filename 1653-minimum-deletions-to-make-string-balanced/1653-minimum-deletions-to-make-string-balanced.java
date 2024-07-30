class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> stk=new Stack<>();
        int res=0;
        for(int i=0;i<s.length();i++){
            if(!stk.isEmpty() && stk.peek()=='b' && s.charAt(i)=='a'){
                stk.pop();
                res++;
            }
            else{
                stk.push(s.charAt(i));
                }
        }
        return res;
    }
}