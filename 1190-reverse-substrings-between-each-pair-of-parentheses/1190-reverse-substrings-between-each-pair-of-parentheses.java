class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> openParenthesesIndices = new Stack<>();
        char charArray[]=s.toCharArray();
        for(int i=0;i<charArray.length;i++){
            if(charArray[i]=='('){
                openParenthesesIndices.push(i);
            }
            else if(charArray[i]==')'){
                reverseString(charArray,openParenthesesIndices.pop()+1,i-1);
            }
        }
        s="";
        for(int i=0;i<charArray.length;i++){
            if(charArray[i]=='(' || charArray[i]==')') continue;
            s+=charArray[i];
        }
        return s;
    }
    public void reverseString(char charArray[],int low,int high){
        while(low<high){
            char ch=charArray[low];
            charArray[low]=charArray[high];
            charArray[high]=ch;
            low++;
            high--;
        }
    }
}