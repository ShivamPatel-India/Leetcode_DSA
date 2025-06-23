class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 2) return true;
        long high = num / 2;
        long low = 2;

        while(low <= high) {
            long mid = low + (high - low) / 2;
            if(mid * mid == num) return true;
            else if(mid * mid > num) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}