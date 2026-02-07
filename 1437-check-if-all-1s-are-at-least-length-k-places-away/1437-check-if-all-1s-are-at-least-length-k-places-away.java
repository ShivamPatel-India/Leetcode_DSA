class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int spaces = k;
        for(int n: nums) {
            if(n == 1) if(spaces < k) return false; else spaces = 0;
            else spaces += 1;
        } 
        return true;
    }
}