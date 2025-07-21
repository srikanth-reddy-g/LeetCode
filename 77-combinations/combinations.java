class Solution {
    private void generateCombinations(int index, List<Integer> subset, int n, int k, List<List<Integer>> ans) {
        //Base case
        if (subset.size() >= k) {
            if (subset.size() == k)
                ans.add(new ArrayList<>(subset));
            return;
        }
        for (int i = index; i <= n; i++) {
            subset.add(i);
            generateCombinations(i + 1, subset, n, k, ans);
            subset.remove(subset.size() - 1);
        }

    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        generateCombinations(1, new ArrayList<Integer>(), n, k, ans);
        return ans;
    }
}

// n=4   [1,2,3,4]
//        0 1 2 3
//                                 ans = []
//                              f(1,[],k)
//                              /    \      \
//                      f(2,[1,])  f(3,[2])  f(4,[3])
//                      /   \ 
//             f(3,[1,2]) f(4,[1,3])