class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> arr=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                arr.add(sum);
            }
        }
        Collections.sort(arr);
        int ans=0;
        int mod=(int)1e9+7;
        for(int i=left-1;i<=right-1;i++){
            ans=(ans+arr.get(i))%mod;
        }
        return ans;
    }
}