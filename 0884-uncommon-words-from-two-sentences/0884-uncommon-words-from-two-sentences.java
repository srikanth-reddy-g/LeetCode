class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String arrOfStr1[]=s1.split(" ");
        String arrOfStr2[]=s2.split(" ");
        ArrayList<String> result=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        for(String str: arrOfStr1){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        for(String str: arrOfStr2){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        for(Map.Entry<String, Integer> e: map.entrySet()){
            if(e.getValue()==1){
                result.add(e.getKey());
            }
        }
        String[] res = result.toArray(new String[0]);
        return res;
    }
}