class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pascalRow = new ArrayList<>();
        long value = 1;
        //since first value in each row will be one 
        pascalRow.add(1);
        for (int i = 0; i < rowIndex; i++) {
            value = value * (rowIndex - i);
            value = value / (i + 1);
            pascalRow.add((int)value);
        }
        return pascalRow;
    }
}