class Solution {
    public int minimumPushes(String word) {
        int countMap[]=new int[26];
        for(int i=0;i<word.length();i++){
            countMap[word.charAt(i)-97]++;
        }
        Arrays.sort(countMap);
        int ans=0;
        int j=1;
        for(int i=25;i>=0;i--){
            ans+=j*countMap[i];
            if(i==18 || i==10 || i== 2) j++;
        }
        return ans;
    }
}