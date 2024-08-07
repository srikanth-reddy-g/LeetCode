class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int ans=0;
        for(int i=0;i<s.length();i++){
            char presentChar=s.charAt(i);
            if(presentChar=='I' || presentChar=='X' || presentChar=='C'){
                if((i+1)<s.length()){
                    if(presentChar=='I' && s.charAt(i+1)=='V') {
                        ans+=4;
                        i++;
                        continue;
                    }
                    if(presentChar=='I' && s.charAt(i+1)=='X') {
                        ans+=9;
                        i++;
                        continue;
                    }
                    if(presentChar=='X' && s.charAt(i+1)=='L') {
                        ans+=40;
                        i++;
                        continue;
                    }
                    if(presentChar=='X' && s.charAt(i+1)=='C') {
                        ans+=90;
                        i++;
                        continue;
                    }
                    if(presentChar=='C' && s.charAt(i+1)=='D') {
                        ans+=400;
                        i++;
                        continue;
                    }
                    if(presentChar=='C' && s.charAt(i+1)=='M') {
                        ans+=900;
                        i++;
                        continue;
                    }
                }
            }
            ans+=map.get(presentChar);
        }
        return ans;
    }
}