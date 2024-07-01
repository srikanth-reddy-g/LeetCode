class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        int stringLength=s.length()-1;
        int length=0;
        int i=0;
        while(stringLength>=0){
            if(s.charAt(i)==' ') length=0;
            else
            length++;
            stringLength--;
            i++;
        }
        return length;
    }
}