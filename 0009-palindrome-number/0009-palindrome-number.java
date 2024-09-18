class Solution {
    public boolean isPalindrome(int x) {
        int actualNumber = x;
        int reverseNumber = 0 ;
        while (x>0){
            int lastDigit = x % 10 ;
            reverseNumber = (reverseNumber*10) + lastDigit;
            x = x / 10;
        }
        if (reverseNumber == actualNumber)
        return true;
        else
        return false;
    }
}