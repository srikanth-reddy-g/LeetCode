class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String wordArray[]=sentence.split(" ");
        Set <String> dictionarySet = new HashSet<>(dictionary);

        for(int i=0;i<wordArray.length;i++){
            wordArray[i]=findRoot(wordArray[i],dictionarySet);
        }
        return String.join(" ",wordArray);
    }
    public String findRoot(String word, Set<String> dictionarySet){
        for(int i=1;i<=word.length();i++){
            String root=word.substring(0,i);
            if(dictionarySet.contains(root)){
                return root;
            }
        }
        return word;
    }
}