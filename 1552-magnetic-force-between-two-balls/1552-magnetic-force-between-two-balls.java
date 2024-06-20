class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low=0;
        int high=position[position.length-1]-position[0];
        while(low<=high){
            int mid=(low+high)/2;
            if(checkMagneticForce(position,m,mid)){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return high;
    }
    public boolean checkMagneticForce(int position[],int m,int minForce){
        int ballCount=1;
        int lastBallPosition=position[0];
        for(int i=1;i<position.length;i++){
            if(position[i]-lastBallPosition >= minForce){
                ballCount++;
                lastBallPosition=position[i];
            }
            if(ballCount >= m) return true;
        }
        return false;
    }
}