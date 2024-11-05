class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);

        
        // Brute Force
        // StringBuilder str = new StringBuilder(s);
        // for (int i = 0; i < s.length(); i++) {
        // char ch = str.charAt(0);
        // str.deleteCharAt(0);
        // str.append(ch);
        // if (goal.equals(str.toString()))
        // return true;
        // }
        // return false;
    }
}