class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<Integer>();
        int presentNumber = 1;
        for (int i = 0; i < n; i++) {
            ans.add(presentNumber);
            if (presentNumber * 10 <= n) {
                presentNumber *= 10;
            } else {
                while (presentNumber % 10 == 9 || presentNumber >= n) {
                    presentNumber /= 10;
                }
                presentNumber += 1;
            }
        }
        return ans;
    }
}