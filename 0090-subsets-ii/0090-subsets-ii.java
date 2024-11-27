class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> answer = new ArrayList<>();
        generateSubsets(0, new ArrayList<>(), answer, nums, n);
        return answer;
    }

    public void generateSubsets(int index, List<Integer> subset, List<List<Integer>> answer, int nums[], int n) {
        answer.add(new ArrayList<>(subset));
        if (index >= n) {
            return;
        }
        for (int i = index; i < n; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;

            subset.add(nums[i]);
            generateSubsets(i + 1, subset, answer, nums, n);
            subset.remove(subset.size() - 1);
        }
    }
}