class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answer = new ArrayList<>();
        findSum(1,new ArrayList<Integer>(),answer,k,n);
        return answer;
    }
    public void findSum(int index,List<Integer> sublist,List<List<Integer>> answer, int k,int sum){
        if(sum<0 || sublist.size()>k){
            return;
        }
         if(sum==0 && sublist.size()==k) 
             answer.add(new ArrayList<>(sublist));
        for(int i=index;i<10;i++)
        {
            sublist.add(i);
            findSum(i+1,sublist,answer,k,sum-i);
            sublist.remove(sublist.size()-1);
        }
    }
}