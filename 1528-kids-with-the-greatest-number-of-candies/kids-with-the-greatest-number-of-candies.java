class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxi = Integer.MIN_VALUE;
        List<Boolean> ans = new ArrayList<>();
        for (int num : candies) {
            maxi = Math.max(maxi, num);
        }
        for (int i = 0; i < candies.length; i++) {
            if ((candies[i] + extraCandies) >= maxi)
                ans.add(true);
            else
                ans.add(false);
        }
        return ans;
    }
}