class Solution {
    public int countOfSubstrings(String word, int k) {
        // Brute Force
        int vowelArray[]={-1,-1,-1,-1,-1};
        int consonants=0;
        int ans=0;
        for(int i=0;i<word.length();i++){
            consonants=0;
            for(int m=0;m<5;m++) vowelArray[m]=-1;
            for(int j=i;j<word.length();j++){
                if(word.charAt(j)=='a') vowelArray[0]=1;
                else if(word.charAt(j)=='e') vowelArray[1]=1;
                else if(word.charAt(j)=='i') vowelArray[2]=1;
                else if(word.charAt(j)=='o') vowelArray[3]=1;
                else if(word.charAt(j)=='u') vowelArray[4]=1;
                else consonants++;
                if (vowelArray[0]==1 && vowelArray[1]==1 && vowelArray[2]==1 && vowelArray[3]==1 && vowelArray[4]==1 && consonants==k){
                    ans++;
                }
            }
        }
        return ans++;
    }
}