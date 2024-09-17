class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashSet<Integer> st=new HashSet<>();
        int res[]=new int[2];
        int i=0;
        for(Integer num:nums){
            if(!st.contains(num)){
                st.add(num);
            }
            else{
                res[i++]=num;
            }
        }
        return res;
    }
}