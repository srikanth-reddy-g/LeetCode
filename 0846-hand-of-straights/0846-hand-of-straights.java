class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;
        else{
            Map<Integer,Integer> mpp=new TreeMap<>();
            for(int i=0;i<hand.length;i++){
                mpp.put(hand[i],mpp.getOrDefault(hand[i],0)+1);
            }
            while(mpp.size()>0){
                int initialCard=mpp.entrySet().iterator().next().getKey();
                for(int i=0;i<groupSize;i++){
                    if(!mpp.containsKey(initialCard+i)) return false;
                    mpp.put(initialCard+i,mpp.get(initialCard+i)-1);
                    if(mpp.get(initialCard+i)<=0) mpp.remove(initialCard+i);
                }
            }
        }
        return true;
    }
}