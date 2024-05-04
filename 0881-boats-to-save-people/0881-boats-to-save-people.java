class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int noOfBoats=0;
        Arrays.sort(people);
        int left=0;
        int right=people.length-1;
        while(left<=right){
            if(people[left]+people[right]<=limit){
                noOfBoats++;
                left++;
                right--;
            }else {
                noOfBoats++;
                right--;
            }
        }
        return noOfBoats;
    }
}