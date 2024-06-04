class Solution {
    public int longestPalindrome(String s) {
        int ans=0;
        Map<Character,Integer> mpp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            mpp.put(s.charAt(i),mpp.getOrDefault(s.charAt(i),0)+1);
        }
        boolean odd=false;
        for(Map.Entry<Character,Integer> m: mpp.entrySet()){
            if(m.getValue()%2!=0){
                ans+=(m.getValue()-1);
                odd=true;
            }
            else{
                ans+=m.getValue();
            }

        }
        if(odd==true) ans++;
        return ans;
    }
}