class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n=candidates.length;
        List<List<Integer>> answer= new ArrayList<>();
        generateSubsets(0,new ArrayList<>(),answer,candidates,target,n);
        return answer;
    }
    public void generateSubsets(int index,List<Integer> subset,List<List<Integer>> answer,int[] candidates, int target, int n){
        if(target==0)
        {
            answer.add(new ArrayList<>(subset));
            return;
        }
        if(target<0){
            return;
        }
        for(int i = index;i<n;i++)
        {
            if((i > index) && (candidates[i]==candidates[i-1])) {continue;}
            if(candidates[i]>target){break;}

            subset.add(candidates[i]);
            generateSubsets(i+1,subset,answer,candidates,target-candidates[i],n);
            subset.remove(subset.size()-1);
        }
    }
}