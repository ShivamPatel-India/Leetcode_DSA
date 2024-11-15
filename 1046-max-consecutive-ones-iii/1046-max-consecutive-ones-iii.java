class Solution {
    public int longestOnes(int[] nums, int k) {
        int f = 0, l = 0;
        int n = nums.length;
        int countZero = 0;
        while(l < n){
            if(nums[l] == 0) ++countZero;
            if(countZero > k) {
                if(nums[f] == 0) --countZero;
                ++f;
            }
            ++l;
        }
        return l - f;
    }
}