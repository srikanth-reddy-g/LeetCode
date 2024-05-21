class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generateSubsets(new ArrayList<>(),0,nums,nums.length,ans);
        return ans;
    }
    public void generateSubsets(List<Integer> subset, int index, int nums[],int n,List<List<Integer>> ans){
        if(index>=n){
            ans.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        generateSubsets(subset,index+1,nums,n,ans);
        subset.remove(subset.size()-1);
        generateSubsets(subset,index+1,nums,n,ans);
    }
}