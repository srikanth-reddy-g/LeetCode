class Solution {
    public boolean checkIfPangram(String sentence) {
        int hashArr[]=new int [26];
        for(int i=0;i<sentence.length();i++){
            hashArr[sentence.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(hashArr[i]==0) return false;
        }
        return true;
    }
}