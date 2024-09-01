class Solution {
    public String stringHash(String s, int k) {
        int l=k;
        int sum=0;
        String ans="";
        for(int i=0;i<s.length();i++){
            sum += (s.charAt(i) -'a');
            l--;
            if(l==0){
                sum %= 26;
                ans += (char)(sum+'a');
                sum=0;
                l=k;
            }
        }
        return ans;
    }
}