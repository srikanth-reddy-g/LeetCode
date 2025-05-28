class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int j = 0;
        int i = 0;
        while (i < n) {
            int count = 0;
            char ch = chars[i];
            while (i < n && ch == chars[i]) {
                i++;
                count++;
            }
            chars[j] = ch;
            j++;
            if (count > 1) {
                String num = Integer.toString(count);
                for (int k = 0; k < num.length(); k++) {
                    chars[j++] = num.charAt(k);
                }
            }
        }
        return j;
    }
}