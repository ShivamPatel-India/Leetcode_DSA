class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int spaces = k;
        for(int num: nums) {
            if(num == 1) {
                if(spaces < k) return false;
                spaces = 0;
            } else spaces += 1;
        }
        return true;
    }
}