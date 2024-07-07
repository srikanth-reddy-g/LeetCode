class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res=numBottles;
        int remaining=0;
        while(numBottles>=numExchange){
            res+=numBottles/numExchange;
            remaining=numBottles-((numBottles/numExchange)*numExchange);
            numBottles=remaining+(numBottles/numExchange);
        }
        return res;
    }
}