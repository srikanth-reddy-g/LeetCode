class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        permutations(new ArrayList<>(),answer,nums);
        return answer;
    }
    public void permutations(List<Integer> sublist,List<List<Integer>> answer,int nums[]){
        if(sublist.size()==nums.length){
            answer.add(new ArrayList<>(sublist));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(!sublist.contains(nums[i]))
            {sublist.add(nums[i]);
            permutations(sublist,answer,nums);
            sublist.remove(sublist.size()-1);}
        }
    }
}