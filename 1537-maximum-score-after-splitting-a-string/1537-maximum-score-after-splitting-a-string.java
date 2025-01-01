class Solution {
    public int maxScore(String s) {
        int totalOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                totalOnes++;
        }
        int currentZeros=0;
        int currentOnes=0;
        int maxScore=Integer.MIN_VALUE;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == '0')
                currentZeros++;
            else currentOnes++;
            maxScore=Math.max(maxScore,currentZeros+(totalOnes-currentOnes));
        }
        return maxScore;
    }
}