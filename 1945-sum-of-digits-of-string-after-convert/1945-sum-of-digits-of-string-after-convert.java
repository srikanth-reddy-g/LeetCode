class Solution {
    public int getLucky(String s, int k) {
        StringBuilder convert=new StringBuilder();
        for(int i=0;i<s.length();i++){
            convert.append(s.charAt(i)-'a'+1);
        }
        int sum=0;
        for(int j=0;j<k;j++){
            sum=0;
            for(int i=0;i<convert.length();i++){
                sum+=Character.getNumericValue(convert.charAt(i));
            }
            convert.delete(0,convert.length());
            convert.append(Integer.toString(sum));
        }
        return sum;
    }
}