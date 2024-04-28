class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        permutations(0,new ArrayList<>(),answer,nums);
        return answer;
    }
    public void permutations(int index,List<Integer> sublist,List<List<Integer>> answer,int nums[]){
        if(index==nums.length){
            answer.add(new ArrayList<>(sublist));
            return;
        }
        for(int i=index;i<nums.length;i++)
        {
            swap(nums, index, i);
            sublist.add(nums[index]);
            permutations(index+1,sublist,answer,nums);
            sublist.remove(sublist.size()-1);
            swap(nums, index, i);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}