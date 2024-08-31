class Solution {
    public int generateKey(int num1, int num2, int num3) {
        String numStr1 = String.format("%04d", num1);
        String numStr2 = String.format("%04d", num2);
        String numStr3 = String.format("%04d", num3);
        String key="";
        for(int i=0;i<4;i++){
            int minValue=Integer.MAX_VALUE;
            minValue=Math.min(minValue,Character.getNumericValue(numStr1.charAt(i)));
            minValue=Math.min(minValue,Character.getNumericValue(numStr2.charAt(i)));
            minValue=Math.min(minValue,Character.getNumericValue(numStr3.charAt(i)));
            key+=Integer.toString(minValue);
        }
        return Integer.parseInt(key);
    }
}