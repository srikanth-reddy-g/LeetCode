class Solution {
    private int sum;
    public int subsetXORSum(int[] nums) {
        int xorSum[]=new int[1];
        generateSubsets(new ArrayList<>(),0,nums,nums.length,xorSum);
        return sum;
    }
    public void generateSubsets(List<Integer> list,int i,int nums[],int n,int xorSum[]){
        if(i>=n){
            sum+=xorSum[0];
            return;
        }
        list.add(nums[i]);
        xorSum[0]^=list.get(list.size()-1);
        generateSubsets(list,i+1,nums,n,xorSum);
        xorSum[0]^=list.get(list.size()-1);
        list.remove(list.size()-1);
        generateSubsets(list,i+1,nums,n,xorSum);
    }
}