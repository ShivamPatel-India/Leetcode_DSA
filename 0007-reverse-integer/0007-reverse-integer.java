class Solution {
    public int reverse(int x) {
        int reversed = 0;
        while(x!=0) {
            int lastDigit = x % 10; // get the last digit of the number

             // Check for overflow/underflow before updating ans
            if ((reversed > Integer.MAX_VALUE / 10) || (reversed < Integer.MIN_VALUE / 10)) {
                return 0; // Return 0 if reversing x would cause overflow/underflow
            }

            reversed = reversed * 10 + lastDigit;
            x = x / 10;
        }
        return reversed;
    }
}