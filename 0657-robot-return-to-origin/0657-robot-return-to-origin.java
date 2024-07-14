class Solution {
    public boolean judgeCircle(String moves) {
        int coordinates[]={0,0};
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='L')  coordinates[0]++;
            else if(moves.charAt(i)=='R') coordinates[0]--;
            else if(moves.charAt(i)=='U') coordinates[1]++;
            else coordinates[1]--;
        }
        return coordinates[0]==0 && coordinates[1]==0;
    }
}