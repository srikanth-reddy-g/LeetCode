class Solution {
    public boolean isAnagram(String s, String t) {
        int sArray[]=new int[27];
        int tArray[]=new int[27];
        for(int i=0;i<s.length();i++){
            sArray[(int)s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            tArray[(int)t.charAt(i)-'a']++;
        }
        for(int i=0;i<sArray.length;i++){
            if (sArray[i]!=tArray[i])
            return false;
        }
        return true;
    }
}