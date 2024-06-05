class Solution {
    public List<String> commonChars(String[] words) {
        int presentCharacters[]=new int[26];
        int sameCharacters[]=new int[26];
        List<String> ans=new ArrayList<>();
        for(char ch:words[0].toCharArray()){
            sameCharacters[ch -'a']++;
        }
        for(int i=1;i<words.length;i++){
            Arrays.fill(presentCharacters,0);
            for(char ch:words[i].toCharArray()){
                presentCharacters[ch -'a']++;
            }
            for(int j=0;j<26;j++){
                sameCharacters[j]=Math.min(presentCharacters[j],sameCharacters[j]);
            }
        }
        for(int i=0;i<26;i++){
            for(int j=0;j<sameCharacters[i];j++){
                ans.add(String.valueOf((char)(i+'a')));
            }
        }
        return ans;
    }
}