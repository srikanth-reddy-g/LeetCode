class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        // Create a list to hold pairs of (mapped number, original index)
        List<int[]> listPair=new ArrayList<>();
        
        
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            String newNum="";
            
            
            if(num==0){
                listPair.add(new int[]{mapping[0],i});
                continue;
            }

            // Convert the number using the given mapping
            while(num!=0){
                newNum=mapping[num%10]+newNum;
                num/=10;
            }
            // Add the mapped number and the original index as a pair to the list
            listPair.add(new int[]{Integer.valueOf(newNum),i});
        }
        
        // Sort the list of pairs based on the mapped number
        Collections.sort(listPair, (a,b) -> a[0] - b[0] );
        
        
        int ans[]=new int[nums.length];
        // Fill the result array with the original numbers in the sorted order
        for (int i = 0; i < nums.length; i++) {
            ans[i]=nums[listPair.get(i)[1]];
        }
        return ans;
    }
}