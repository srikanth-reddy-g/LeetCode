class Solution {
    public double averageWaitingTime(int[][] customers) {
        double res=0;
        int totalTime=customers[0][0];
        for(int i=0;i<customers.length;i++){
            if(customers[i][0] <= totalTime) totalTime+=customers[i][1];
            else {
                totalTime=customers[i][0];
                totalTime+=customers[i][1];
            }
            res+=(totalTime-customers[i][0]);
        }
        return res/customers.length;
    }
}