class Solution {
    public int maximumGain(String s, int x, int y) {
        int totalScore=0;
        String highPriority = x > y ? "ab" : "ba";
        String lowPriority = "ab".equals(highPriority) ? "ba" : "ab";

        // First pass: remove high priority pair
        String stringAfterFirstPass=removeString(s,highPriority);
        int removedPairs=(s.length()-stringAfterFirstPass.length())/2;

        // Calculate score from first pass
        totalScore+=removedPairs*Math.max(x,y);

        // Second pass: remove low priority pair
        String stringAfterSecondPass=removeString(stringAfterFirstPass,lowPriority);
        removedPairs=(stringAfterFirstPass.length()-stringAfterSecondPass.length())/2;

        // Calculate score from first pass
        totalScore+=removedPairs*Math.min(x,y);
        return totalScore;
    }
    private String removeString(String s, String removeString ){
        Stack<Character> charStack=new Stack<>();

        // Iterate through each character in the input string
        for(int i=0;i<s.length();i++){

            // Check if current character forms the target pair with the top of the stack
            if((!charStack.isEmpty()) && 
            (s.charAt(i)==(removeString.charAt(1))) && 
            (charStack.peek()==(removeString.charAt(0))))
            {
                charStack.pop();    // Remove the matching character from the stack
            }
            else
            charStack.push(s.charAt(i));
        }

        // Reconstruct the remaining string after removing target pairs
        
        StringBuilder stringAfterRemoval=new StringBuilder();
        while(!charStack.isEmpty()){
            stringAfterRemoval.append(charStack.pop());
        }
        return stringAfterRemoval.reverse().toString();
    }
}