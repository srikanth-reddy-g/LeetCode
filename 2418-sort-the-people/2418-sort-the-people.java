class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n=heights.length;
        // Creating a map to associate each height with the corresponding name
        Map<Integer,String> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(heights[i],names[i]);
        }
        // Sorting the heights array in ascending order
        Arrays.sort(heights);
        
        // Reconstructing the names array based on the sorted heights in descending order
        for(int i=n-1;i>=0;i--){
            names[n-1-i]=map.get(heights[i]);
        }
        return names;
    }
}