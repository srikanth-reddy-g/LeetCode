class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n==0) return 0;
        int left=0,right=0;
        int length=0;
        //map to check if the character has been seen or not
        HashMap<Character,Integer> map=new HashMap<>();
        //iterating the loop till the right pointer reached the end of the array
        while(right<n)
        {
            // condition to check if the character is present in the map
            if (map.containsKey(s.charAt(right)))
            {
                //condition to check if the current character is in between the left and right pointer
                left=Math.max(map.get(s.charAt(right))+1,left);
            }
            // if the character is not present in map insert it,
            // if present update the index and find the max length
            map.put(s.charAt(right),right);
            length=Math.max(length,right+1-left);
            right++;
        }
        return length;
    }
}