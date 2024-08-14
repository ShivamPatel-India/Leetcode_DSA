class Solution {
    public int singleNumber(int[] nums) {
        int odd = 0;
        for(int i = 0; i < nums.length; i++) {
            odd = odd ^ nums[i];
        }

        return odd;
    }
}