class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> subset = new ArrayList();
        generateSubsets(0, subset, answer, candidates, target, n);
        return answer;
    }

    public void generateSubsets(int index, List<Integer> subset, List<List<Integer>> answer, int[] candidates,
            int target, int n) {
        if (index >= n || (target <= 0)) {
            if (target == 0) {
                answer.add(new ArrayList<>(subset));
            }
            return;
        }
        subset.add(candidates[index]);
        target -= candidates[index];
        generateSubsets(index, subset, answer, candidates, target, n);
        subset.remove(subset.size() - 1);
        target += candidates[index];
        generateSubsets(index + 1, subset, answer, candidates, target, n);
    }
}