class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10; // Last digit nikalne ke liye
            x /= 10;
            
            // Max value (2147483647) se overflow check karne ke liye
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            // Min value (-2147483648) se underflow check karne ke liye
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            
            rev = rev * 10 + pop;
        }
        return rev;
    }
}